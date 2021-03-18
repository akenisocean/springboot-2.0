package com.ocean.springcloud.oceansecurity;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chao
 * @description: security测试controller
 * @create: 2020-05-06 23:00
 */
@RestController
public class SecurityController {



    @GetMapping("/")
    public String home(){
        return "hello spring boot";
    }

    /**
     * 对hello的url请求会进行拦截操作
     * @return
     */
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }


    /**
     * RoleVoter中定义了前缀为ROLE来进行识别
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PostAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/roleAuth")
    public String role(){
        return "admin auth";
    }

}
