package com.ocean.springcloud;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class OceanAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OceanAdminServerApplication.class, args);
	}

}
