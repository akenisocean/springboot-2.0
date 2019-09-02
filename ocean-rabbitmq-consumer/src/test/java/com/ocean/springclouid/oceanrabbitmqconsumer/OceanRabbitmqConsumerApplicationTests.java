package com.ocean.springclouid.oceanrabbitmqconsumer;

import com.ocean.springclouid.oceanrabbitmqconsumer.entity.Order;
import com.ocean.springclouid.oceanrabbitmqconsumer.producer.RabbitOrderSender;
import com.ocean.springclouid.oceanrabbitmqconsumer.producer.RabbitSender;
import com.ocean.springclouid.oceanrabbitmqconsumer.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OceanRabbitmqConsumerApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	private RabbitSender rabbitSender;

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	@Test
	public void testSender1() throws Exception {
		Map<String, Object> properties = new HashMap<>();
		properties.put("number", "12345");
		properties.put("send_time", simpleDateFormat.format(new Date()));
		rabbitSender.send("Hello RabbitMQ For Spring Boot!", properties);
	}


	@Autowired
	private RabbitOrderSender rabbitOrderSender;

	@Test
	public void testSender2() throws Exception {
		Order order = new Order();
		order.setId("2018080400000001");
		order.setName("测试订单");
		order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
		rabbitOrderSender.sendOrder(order);
	}


	@Autowired
	private OrderService orderService;

	@Test
	public void testCreateOrder() throws Exception {
		Order order = new Order();
		order.setId("2018080400000005");
		order.setName("测试创建订单");
		order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
		orderService.createOrder(order);
	}
}
