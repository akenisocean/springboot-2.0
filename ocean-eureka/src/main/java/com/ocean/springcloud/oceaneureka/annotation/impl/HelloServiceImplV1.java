package com.ocean.springcloud.oceaneureka.annotation.impl;

import com.ocean.springcloud.oceaneureka.annotation.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author 季超
 * @create 2018-11-23 12:33
 * @desc
 **/
@Component
public class HelloServiceImplV1 implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("Hello from V1");
    }

    @Override
    public void sayHi() {
        System.out.println("Hi from V1");
    }
}
