package com.ocean.springclouid.oceanrabbitmqconsumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ocean.springclouid.oceanrabbitmqconsumer.mapper")
@EnableScheduling
public class OceanRabbitmqConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OceanRabbitmqConsumerApplication.class, args);
	}


	@Bean
	public ApplicationRunner runner(AmqpTemplate template) {
		return args -> template.convertAndSend("myqueue", "foo");
	}

	@Bean
	public Queue myQueue() {
		return new Queue("myqueue");
	}

	@RabbitListener(queues = "myqueue")
	public void listen(String in) {
		System.out.println(in);
	}
	@Bean
	public DirectExchange myExchange(){
		return new DirectExchange("myExchange");
	}

	@Bean
	public Binding  bindingExchangeMy(){
		return BindingBuilder.bind(myQueue()).to(myExchange()).with("myqueue");
	}


	//创建交换机

	@Bean
	public DirectExchange orderExchange1(){
		return new DirectExchange("order-exchange11");
	}

	@Bean
	public Queue orderQueue11() {
		return new Queue("orderQueue11");
	}

	@Bean
	public Binding bindingExchangeOrder11(){
		return BindingBuilder.bind(orderQueue11()).to(orderExchange1()).with("order.ABC");
	}



}
