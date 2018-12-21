package com.ocean.springcloud.oceanfeignprovider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OceanFeignProvider2Application {

	public static void main(String[] args) {
		SpringApplication.run(OceanFeignProvider2Application.class, args);
	}

}

