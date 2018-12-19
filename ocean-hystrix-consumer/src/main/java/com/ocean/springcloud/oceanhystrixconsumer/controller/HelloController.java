package com.ocean.springcloud.oceanhystrixconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 季超
 * @create 2018-11-23 11:28
 * @desc 进行AB测试的controller层
 **/
@RestController
public class HelloController {


    @Autowired
    private HelloService helloService;


    @GetMapping("/sayHello")
    public String sayHello(HttpServletRequest request){
        String header = request.getHeader("X-Request-Foo");
        System.out.println("请求头X-Request-Foo的值为"+header);

        return helloService.sayHello();
    }

    @GetMapping("/sayHi")
    public void sayHi(){
    }




}
