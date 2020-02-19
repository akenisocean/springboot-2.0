package com.ocean.springcloud.oceankafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class OceanKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OceanKafkaApplication.class, args);
	}

}
