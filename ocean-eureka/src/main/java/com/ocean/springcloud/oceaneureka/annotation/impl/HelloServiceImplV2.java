package com.ocean.springcloud.oceaneureka.annotation.impl;

import com.ocean.springcloud.oceaneureka.annotation.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author 季超
 * @create 2018-11-23 12:35
 * @desc
 **/
@Component
public class HelloServiceImplV2 implements HelloService{
    @Override
    public void sayHello() {
        System.out.println("Helllo from V2");
    }

    @Override
    public void sayHi() {
        System.out.println("Hi from V2");
    }

}
