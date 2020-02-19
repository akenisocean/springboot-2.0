package com.ocean.springcloud.oceanrabbitproducer;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年05月30日 16:42
 */
public class Producer {
    @Test
    public void testBasicPublish() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("/");
        factory.setHost("114.67.224.231");
        factory.setPort(AMQP.PROTOCOL.PORT);
        factory.setUsername("guest");
        factory.setPassword("guest");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String EXCHANGE_NAME = "exchange.direct";
        String QUEUE_NAME = "queue_name";
        String ROUTING_KEY = "key";
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

        String message = "Hello RabbitMQ:";
        for (int i = 0; i < 5; i++) {
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, (message + i).getBytes("UTF-8"));
        }

        channel.close();
        connection.close();
    }
}