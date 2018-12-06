package com.ocean.springcloud.oceaneureka.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 季超
 * @create 2018-11-30 15:13
 * @desc
 **/
public class MyBeanPostProcess implements BeanPostProcessor{

    private static final List<String> list = new ArrayList<>();

    private static final AtomicInteger in = new AtomicInteger(2);
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
       while (true){
           list.add("abc"+in.getAndIncrement());

       }

    }
}
