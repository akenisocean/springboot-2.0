package com.ocean.springcloud.oceankafkaspringboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

/**
 * @author: chao
 * @description: topic创建
 * @create: 2020-11-17 14:17
 */
@Configuration
public class TopicCreateConfig {


    public static final String idenpotentTopic = "idenpotent-topic";


    public static final String TOPIC = "users";
    public static final String ERROR_TOPIC = "users-error";


    @Bean
    public NewTopic idenpotentTopic(){
        return new NewTopic(TOPIC, Optional.of(2),Optional.of(Short.parseShort("1")));
    }


    @Bean
    public NewTopic idenpotentTopic2(){
        return new NewTopic(ERROR_TOPIC, Optional.of(2),Optional.of(Short.parseShort("1")));
    }

}
