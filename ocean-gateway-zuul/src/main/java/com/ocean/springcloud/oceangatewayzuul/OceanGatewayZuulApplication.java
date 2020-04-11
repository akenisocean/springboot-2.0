package com.ocean.springcloud.oceangatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class OceanGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(OceanGatewayZuulApplication.class, args);
	}

}
