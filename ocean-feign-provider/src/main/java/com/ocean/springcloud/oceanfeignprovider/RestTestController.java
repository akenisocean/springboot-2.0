package com.ocean.springcloud.oceanfeignprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: chao
 * @description: rest测试controller
 * @create: 2020-03-02 21:08
 */
@RestController
@RequestMapping("/feign")
public class RestTestController {

   @Autowired
   FeignProviderController feignProviderController;

    @GetMapping("/test1")
    public Map<String,String> test1(){
        return feignProviderController.test1();
    }

}
