package com.ocean.springcloud.oceanconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class OceanConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OceanConfigServerApplication.class, args);
	}
}
