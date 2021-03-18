package com.ocean.springcloud.oceankafkaspringboot.consumer;

import com.ocean.springcloud.oceankafkaspringboot.config.TopicCreateConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author: chao
 * @description:
 * @create: 2020-10-16 16:22
 */
@Component
@Slf4j
public class Consumer {


    @KafkaListener(topics = TopicCreateConfig.TOPIC/*,groupId = "ocean-group"*/)
    public void consume(String message, ConsumerRecord record, Acknowledgment acknowledgment) {
        log.info(String.format("#### -> Consumed message -> %s-> 当前的partition为:%s", message,record.offset()));
        acknowledgment.acknowledge();
    }

    @KafkaListener(topics = TopicCreateConfig.ERROR_TOPIC, topicPattern = "0", errorHandler = "customKafkaListenerErrorHandler"/*,groupId = "ocean-group"*/)
    public void suerErroConsumer(String in, ConsumerRecord record, Acknowledgment acknowledgment) {
        log.info("Received:{},当前的partition为:{} ", in, record.partition());
        if (in.startsWith("foo")) {
            acknowledgment.nack(TimeUnit.MINUTES.toMillis(3));
            log.error("failed");
        } else {
            acknowledgment.acknowledge();
        }
    }

    @KafkaListener(topics = TopicCreateConfig.ERROR_TOPIC, topicPattern = "1", errorHandler = "customKafkaListenerErrorHandler"/*,groupId = "ocean-group"*/)
    public void suerErroConsumer2(String in, ConsumerRecord record, Acknowledgment acknowledgment) {
        log.info("Received2:{},当前的partition为:{} ", in, record.partition());
        if (in.startsWith("foo")) {
            acknowledgment.nack(TimeUnit.SECONDS.toMillis(3));
            log.error("failed");
        } else {
            acknowledgment.acknowledge();
        }
    }


}
