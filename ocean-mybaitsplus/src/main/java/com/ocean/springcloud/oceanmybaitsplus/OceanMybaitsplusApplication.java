package com.ocean.springcloud.oceanmybaitsplus;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//扫描DAO
@MapperScan(basePackages = {"com.ocean.springcloud.oceanmybaitsplus.dao"})
@EnableSwagger2
//@EnableKnife4j
public class OceanMybaitsplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(OceanMybaitsplusApplication.class, args);
	}

}
