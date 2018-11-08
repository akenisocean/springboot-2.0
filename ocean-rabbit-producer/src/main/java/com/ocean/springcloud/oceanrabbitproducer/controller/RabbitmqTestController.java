package com.ocean.springcloud.oceanrabbitproducer.controller;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 季超
 * @create 2018-11-08 16:48
 * @desc
 **/
@RestController
@RequestMapping("/test")
public class RabbitmqTestController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/test1")
    public void test1(){
        for (int i = 0; i < 30; i++) {

            rabbitTemplate.convertAndSend("topic.exchange","topic.abc","这是一个测试【"+i+"】");
        }

    }

    @GetMapping("/test2")
    public void test2(){
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                MessageProperties properties = message.getMessageProperties();
                properties.setDelay(5000);
                return message;
            }
        };

        rabbitTemplate.convertAndSend("delay.exchange","delay.abc","这是第二个一个测试",messagePostProcessor);
    }

}
