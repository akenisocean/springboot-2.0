package com.ocean.springcloud.oceanmybaitsplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描DAO
@MapperScan(basePackages = {"com.ocean.springcloud.oceanmybaitsplus.dao"})
public class OceanMybaitsplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(OceanMybaitsplusApplication.class, args);
	}

}
