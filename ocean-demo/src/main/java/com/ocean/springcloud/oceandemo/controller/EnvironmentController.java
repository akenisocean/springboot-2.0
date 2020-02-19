package com.ocean.springcloud.oceandemo.controller;

import com.ocean.springcloud.oceandemo.redis.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chao
 * @version 1.0
 * @desc 环境controller层
 * @date 2019年08月12日 10:20
 */
@RestController
//@Profile(value = "dev")
public class EnvironmentController {

    @GetMapping("/test")
    public User test() {
        User user = new User();
        user.setName("123");
        user.setPassword("456");
        return user;
    }

    /**
     * 系统名称
     */
    @Value("${example.systemName:default}")
    private String systemName;

    /**
     * 访问函数
     */
    @GetMapping("/access")
    public String access() {
        return String.format("系统(%s)欢迎您访问！", systemName);
    }

    @Value("${smart:200}")
    private String smart;
    //    @Value("${smart2}")
    private String smart2;

    @GetMapping("/smart")
    public String smart() {
        return String.format("系统(%s)欢迎您访问！", smart);
    }

    @GetMapping("/smart2")
    public String smart2() {
        return String.format("系统(%s)欢迎您访问！", smart2);
    }


}
