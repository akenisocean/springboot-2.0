package com.ocean.springcloud.oceanhystrixconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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


    public String helloFallback(){
        log.info("【失败线程名称为】："+Thread.currentThread().getName());
        return "error";
    }

    @HystrixCommand(fallbackMethod = "helloFallback",threadPoolKey = "helloThreadPool",
            threadPoolProperties = {@HystrixProperty(name = "coreSize",value = "30"),
                    @HystrixProperty(name = "maxQueueSize",value = "10"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")},
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),//指定多久超时，单位毫秒。超时进fallback
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//判断熔断的最少请求数，默认是10；只有在一个统计窗口内处理的请求数量达到这个阈值，才会进行熔断与否的判断
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),//判断熔断的阈值，默认值50，表示在一个统计窗口内有50%的请求处理失败，会触发熔断
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds" , value = "10000") //熔断多少毫秒后开始尝试请求 默认5000ms

            })
    public String sayHello() {
        log.info("【当前线程名称为】："+Thread.currentThread().getName());
        return restTemplate.getForEntity("http://ocean-hystrix-provider/sayHello",String.class).getBody();

    }
}
