package com.ocean.springcloud.oceandemo.controller.幂等测试;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chao
 * @version 1.0
 * @desc 幂等controller层
 * @date 2019年08月15日 11:38
 */
@RestController
@RequestMapping("/token")
public class IdempotentController {

    private int i = 0;

//    @Autowired
//    private TokenService tokenService;
//
//    @GetMapping
//    public ServerResponse token() {
//        return tokenService.createToken();
//    }

    @GetMapping("/testIdempotent")
    @ApiIdempotent
    public void testIdempotent() {
        System.out.println(i);
    }
}
