package com.ocean.springcloud.oceanhystrixconsumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author chao
 * @version 1.0
 * @desc 断路器Controller层
 * @date 2019年07月19日 15:50
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixController {


    @GetMapping("/sayHello")
    public String sayHello() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sayHello.hello";
    }

    @GetMapping("/incaseoffailureusethis")
    public String incaseoffailureusethis() {
        return "consumer.incaseoffailureusethis.fallback";
    }

    @GetMapping("/fallback")
    public String fallback() {
        return "consumer.fallback";
    }
}
