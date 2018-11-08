package com.ocean.springcloud.oceanrabbitmqproducer2.listener;

import org.springframework.stereotype.Component;

/**
 * @author 季超
 * @create 2018-11-08 17:01
 * @desc
 **/
@Component
public class RabbitListener {



     @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = {"topic.queue"})
    public void haha(String msg){
         System.err.println("开始接受数据了");
         System.err.println(msg.toString());
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = {"delay.queue"})
    public void haba(String msg){
        System.err.println("delay开始接受数据了了");
        System.err.println(msg.toString());

    }


    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = {"topic.queue"})
    public void haha2(String msg){
        System.err.println("开始接受数据了");
        System.err.println(msg.toString());
    }


}
