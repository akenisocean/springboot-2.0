package com.ocean.springcloud.oceangateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chao
 * @version 1.0
 * @desc 返回controller层
 * @date 2019年07月19日 16:52
 */
@RestController
@RequestMapping()
public class ReturnController {

//    @RequestMapping("/fallback")
//    public String fallback(){
//        return "gateway.fallback.error";
//    }


    @GetMapping("/incaseoffailureusethis")
    public String incaseoffailureusethis(){
        return "Hystrix.incaseoffailureusethis";
    }

}
