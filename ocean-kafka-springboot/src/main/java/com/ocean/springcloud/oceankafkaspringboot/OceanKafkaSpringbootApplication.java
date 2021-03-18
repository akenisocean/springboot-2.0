package com.ocean.springcloud.oceankafkaspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class OceanKafkaSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(OceanKafkaSpringbootApplication.class, args);
	}

}
