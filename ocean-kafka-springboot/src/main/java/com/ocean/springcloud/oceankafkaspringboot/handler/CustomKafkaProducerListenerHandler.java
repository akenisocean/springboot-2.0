package com.ocean.springcloud.oceankafkaspringboot.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

/**
 * @author: chao
 * @description: 生产消息监听端设置
 * @create: 2020-10-16 18:58
 */
@Slf4j
public class CustomKafkaProducerListenerHandler<K, V> implements ProducerListener<K, V> {


    @Override
    public void onSuccess(ProducerRecord<K, V> producerRecord, RecordMetadata recordMetadata) {
        log.info("producer 发送消息入kafka成功。。。");
    }

    @Override
    public void onError(ProducerRecord<K, V> record, Exception exception) {
        log.error("producer 发送消息入kafka失败-----------------------------");
    }


}
