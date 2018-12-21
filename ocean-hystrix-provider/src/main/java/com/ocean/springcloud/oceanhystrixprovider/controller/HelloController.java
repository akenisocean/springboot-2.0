package com.ocean.springcloud.oceanhystrixprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author 季超
 * @create 2018-11-23 11:28
 * @desc 进行AB测试的controller层
 **/
@RestController
public class HelloController {




    @GetMapping("/sayHello")
    public String sayHello(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("provider调用了");

        return "provider今天是个好日子";
    }

    @GetMapping("/sayHi")
    public void sayHi(){
    }




}
