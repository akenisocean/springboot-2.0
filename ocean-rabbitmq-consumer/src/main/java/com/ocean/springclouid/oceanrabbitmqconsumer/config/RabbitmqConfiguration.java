package com.ocean.springclouid.oceanrabbitmqconsumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 季超
 * @create 2018-11-08 18:21
 * @desc
 **/
@Configuration
public class RabbitmqConfiguration {


    @Bean
    public Queue queue(){
        return new Queue("exclusiveQueue",true,true,false);
    }
}
