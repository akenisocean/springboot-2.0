package com.ocean.springcloud.oceanhystrixconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

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
        String value = request.getHeader("Hello");
        System.out.println("请求头Hello的值为"+value);
        System.out.println("请求头X-Request-Foo的值为"+header);

        return helloService.sayHello();
    }

    @GetMapping("/sayHi")
    public String sayHi(){
        return "sayHi";
    }

    @GetMapping("/foo/{laji}")
    public String laji(HttpServletRequest request, HttpServletResponse response, @PathVariable("laji") String laji) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        if (request.getHeaderNames().hasMoreElements()) {
            System.out.println(request.getHeaderNames().nextElement());
        }
        response.setHeader("Access-Control-Allow-Credentials","asdadaadada");
        System.out.println("foo");
        return laji;
    }
    @GetMapping("/bar/{laji}")
    public String bar(@PathVariable("laji") String laji){
        System.out.println("bar");
        return laji;
    }




}
