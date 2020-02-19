package com.ocean.springcloud.oceanfeignprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OceanFeignProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OceanFeignProviderApplication.class, args);
    }

}

