package com.ocean.springcloud.oceandemo.feignTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: chao
 * @description: fei测试
 * @create: 2020-02-27 18:08
 */
@RestController
@RequestMapping("/feigntest")
public class FeignTestController {
    @GetMapping("/test1")
    public Map<String,String> test1(){
        Map<String, String> map = new HashMap<>(2);
        map.put("1","2");
        map.put("2","3");
        return map;
    }
}
