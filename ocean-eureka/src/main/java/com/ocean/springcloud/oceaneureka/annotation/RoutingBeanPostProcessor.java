package com.ocean.springcloud.oceaneureka.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 季超
 * @create 2018-11-23 12:38
 * @desc
 **/
@Component
@Slf4j
public class RoutingBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("【beanName的名称为】：{}"+beanName);
        return bean;
    }


    //在Bean初始化完成后开始执行
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 获取bean对应的class对象
        Class clazz = bean.getClass();
        // 返回的数组 Field对象反映此表示的类或接口声明的所有字段 类对象。
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            //判断该类上是否又RoutingInjected注解
            if (f.isAnnotationPresent(RoutingInjected.class)){
                //该注解如果没有作用在interface接口上，则返回错误
                if (!f.getType().isInterface()){
throw new BeanCreationException("RoutingInjected filed must be declared as an interface:"+f.getName()+"@class"+clazz.getName());
                }
                try {
                    this.handleRoutingInjected(f,bean,f.getType());
                } catch (IllegalAccessException e) {
                    throw new BeanCreationException("Exception thrown when handleAutowiredRouting",e);
                }
            }


        }

        return null;


    }

    private void handleRoutingInjected(Field field, Object bean, Class type) throws IllegalAccessException {
        //返回与给定对象类型（包括子类）匹配的bean实例，从bean定义或FactoryBeans情况下的getObjectType值判断。
        Map<String,Object> candidates = this.applicationContext.getBeansOfType(type);
//        Iterator<Map.Entry<String, Object>> iterator = candidates.entrySet().iterator();
//        while (iterator.hasNext()){
//            log.info("【candidate对象有】：key为：{},value为：{}"+iterator.next().getKey(),iterator.next().getValue());
//        }
        //将该对象设置为可访问状态
        field.setAccessible(true);
        //判断这个类几个
        if(candidates.size() == 1){
            field.set(bean,candidates.values().iterator().next());
            /**
             * 判断是否有两个实现类
             */
        }else if (candidates.size() == 2){
            Object proxy = RoutingBeanProxyFactory.createProxy(type,candidates);
            field.set(bean,proxy);
        }else {
            throw new IllegalArgumentException("Find more than 2 beans for type:"+type);
        }
    }
}
