package com.ocean.springcloud.oceaneureka.annotation;

import com.ocean.springcloud.oceaneureka.annotation.impl.SwitchEnum;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author 季超
 * @create 2018-11-23 13:13
 * @desc
 **/
public class RoutingBeanProxyFactory {


    public static Object createProxy(Class targetClass, Map<String, Object> beans) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(targetClass);
        //将给定的AOP联盟建议添加到建议（拦截器）链的尾部。
        proxyFactory.addAdvice(new VersionRoutingMethodInterceptor(targetClass, beans));
        // 返回代理对象
        return proxyFactory.getProxy();

    }

    @Slf4j
    static class VersionRoutingMethodInterceptor implements MethodInterceptor {
        private String classSwitch;
        private Object beanOfSwitchOn;
        private Object beanOfWitchOff;

        public VersionRoutingMethodInterceptor(Class targetClass, Map<String, Object> beans) {
            log.info("【返回*源代码中给出的基础类的简单名称。】+"+targetClass.getSimpleName());
            String interfaceName = StringUtils.uncapitalize(targetClass.getSimpleName());
            if (targetClass.isAnnotationPresent(RoutingSwitch.class)){
                //获取RoutingSwitch注解中的value
                this.classSwitch = ((RoutingSwitch)targetClass.getAnnotation(RoutingSwitch.class)).value();
            }
            this.beanOfSwitchOn = beans.get(this.buildBeanName(interfaceName,true));
            this.beanOfWitchOff = beans.get(this.buildBeanName(interfaceName,false));
        }

        private String buildBeanName(String interfaceName, boolean isSwitchOn) {
            //对实现类进行封装
            return interfaceName + "Impl" +(isSwitchOn ? "V2":"V1");
        }

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            Method method = invocation.getMethod();
            String switchName = this.classSwitch;
            System.out.println(switchName);
            if (method.isAnnotationPresent(RoutingSwitch.class)){
                switchName = method.getAnnotation(RoutingSwitch.class).value();
            }
            log.info("【switchName的名称为】:{}"+switchName);
            if (StringUtils.isBlank(switchName)){
                throw new IllegalStateException("RoutingSwitch's value is black,method:"+method.getName());
            }
            // 参数1 ：底层调用的对象名称
            return invocation.getMethod().invoke(getTargetBean(switchName),invocation.getArguments());
        }

        private Object getTargetBean(String switchName) {
            boolean switchOn ;
            if(SwitchEnum.A.getSwitchName().equals(switchName)){

                switchOn = false;
            }else if (SwitchEnum.B.getSwitchName().equals(switchName)){
                switchOn = true;
            }else {
                switchOn =  true;
            }
            return switchOn ? beanOfSwitchOn: beanOfWitchOff;


        }
    }
}
