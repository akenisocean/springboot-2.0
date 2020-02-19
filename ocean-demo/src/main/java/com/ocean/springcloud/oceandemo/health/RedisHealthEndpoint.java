package com.ocean.springcloud.oceandemo.health;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chao
 * @version 1.0
 * @desc Redis健康检查端点
 * @date 2019年09月02日 14:30
 */
@Component
@Endpoint(id = "redisHealthEndpoint")
public class RedisHealthEndpoint {

    @Value("${ocean.demo:laji}")
    String oceanDemo;

    @ReadOperation
    public Map<String, Object> endpoint() {
        Map<String, Object> map = new HashMap<>(16);
        map.put("message", "this is my endpoint");
        map.put("ocean.demo", oceanDemo);
        return map;
    }


}
