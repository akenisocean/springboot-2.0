package com.ocean.springcloud.oceangateway.limitresolver;

import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author chao
 * @version 1.0
 * @desc 自定义速率
 * @date 2019年07月25日 14:33
 */
public class MyRateLimiter implements RateLimiter {
    @Override
    public Mono<Response> isAllowed(String routeId, String id) {
        return null;
    }

    @Override
    public Map getConfig() {
        return null;
    }

    @Override
    public Class getConfigClass() {
        return null;
    }

    @Override
    public Object newConfig() {
        return null;
    }
}
