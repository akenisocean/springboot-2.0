package com.ocean.springcloud.oceangateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringCloudApplication
public class OceanGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OceanGatewayApplication.class, args);
	}

}

