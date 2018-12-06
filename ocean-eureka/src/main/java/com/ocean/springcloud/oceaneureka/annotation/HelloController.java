package com.ocean.springcloud.oceaneureka.annotation;

import com.ocean.springcloud.oceaneureka.annotation.impl.RoutingValueConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 季超
 * @create 2018-11-23 11:28
 * @desc 进行AB测试的controller层
 **/
@RestController
@RefreshScope
public class HelloController {

    @RoutingInjected
    private HelloService helloService;

    @Autowired
    private  RoutingValueConfig routingValueConfig;

    @Value("${ab.oceantest}")
    public  String routingValueb;

    @GetMapping("/sayHello")
    public void sayHello(){
//        System.out.println(RoutingValueConfig.routingValue);
        System.out.println(routingValueb);
        helloService.sayHello();
    }

    @GetMapping("/sayHi")
    public void sayHi(){
        helloService.sayHi();
    }




}
