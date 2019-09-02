package com.ocean.springcloud.oceandemo2;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableApolloConfig
@RestController
@EnableDiscoveryClient
public class OceanDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(OceanDemo2Application.class, args);
	}

	@Value("${smart:200}")
	private String smart;

	@GetMapping("/smart")
	public String smart() {
		return String.format("系统(%s)欢迎您访问！", smart);
	}

}
