package com.ocean.springcloud.oceanfeignprovider;

import com.ocean.springcloud.oceanfeignprovider.feign.FeignDefaultConfig;
import com.ocean.springcloud.oceanfeignprovider.feign.FeignProviderFallback;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author: chao
 * @description: feign-controller层
 * @create: 2020-03-02 16:21
 */
@FeignClient(value = "consumer-feign2",path = "/feign"/*,url = "http://localhost:7777"*/,fallback = FeignProviderFallback.class)
@RibbonClient(name = "consumer-feign2")
public interface FeignProviderController {

    @GetMapping("/test1")
    Map<String,String> test1();
}
