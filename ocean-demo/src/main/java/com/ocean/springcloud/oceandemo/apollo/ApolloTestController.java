package com.ocean.springcloud.oceandemo.apollo;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: chao
 * @description: apollo配置中心测试controller
 * @create: 2019-12-13 16:27
 */
@RestController
@RequestMapping("/apollo")
public class ApolloTestController {

    @Autowired
    ApolloTestConfiguration apolloTestConfiguration;

    @GetMapping("/getTestPrefixValue")
    public Map<String, String> getTestPrefixValue() {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("test1", apolloTestConfiguration.getTest1());
        map.put("test2", apolloTestConfiguration.getTest2());
        map.put("test3", apolloTestConfiguration.getTest3());
        return map;
    }
}
