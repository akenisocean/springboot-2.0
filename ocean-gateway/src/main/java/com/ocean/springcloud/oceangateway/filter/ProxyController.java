package com.ocean.springcloud.oceangateway.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.webflux.ProxyExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * @author 季超
 * @create 2018-12-19 19:48
 * @desc
 **/
@RestController
public class ProxyController {

    @Value("${remote.home}")
    private URI home;

    @GetMapping("/test")
    public Mono<ResponseEntity<byte[]>> proxy(ProxyExchange<byte[]> proxy) throws Exception {
        System.out.println(home.toString());
        return proxy.uri(home.toString() + "/sayHello").get();
    }

}
