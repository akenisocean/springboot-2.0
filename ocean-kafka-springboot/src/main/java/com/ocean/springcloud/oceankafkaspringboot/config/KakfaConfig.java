package com.ocean.springcloud.oceankafkaspringboot.config;


import com.ocean.springcloud.oceankafkaspringboot.handler.CustomKafkaProducerListenerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.ProducerListener;

/**
 * @author: chao
 * @description:
 * @create: 2020-10-16 17:28
 */
@Configuration
public class KakfaConfig {

//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory(
//            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
//            ConsumerFactory<Object, Object> kafkaConsumerFactory) {
//        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        configurer.configure(factory, kafkaConsumerFactory);
//        factory.setErrorHandler(new SeekToCurrentErrorHandler());
//        return factory;
//    }



    @Bean
    public ProducerListener<Object, Object> producerListener() {
        return new CustomKafkaProducerListenerHandler();
    }
}
