package com.ocean.springcloud.oceanhystrixconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author 季超
 * @create 2018-11-29 13:37
 * @desc
 **/
@Service
@Slf4j
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloFallback")
    public String sayHello() {
      log.info("【当前线程名称为】："+Thread.currentThread().getName());
      return restTemplate.getForEntity("http://ocean-hystrix-provider/sayHello",String.class).getBody();

    }

    public String helloFallback(){
        log.info("【失败线程名称为】："+Thread.currentThread().getName());
        return "error";
    }
}
