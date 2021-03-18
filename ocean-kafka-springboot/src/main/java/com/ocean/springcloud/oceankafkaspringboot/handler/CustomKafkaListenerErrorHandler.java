package com.ocean.springcloud.oceankafkaspringboot.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: chao
 * @description: 自定义消费错误处理handler
 * @create: 2020-10-16 18:04
 */
@Slf4j
@Component
public class CustomKafkaListenerErrorHandler implements KafkaListenerErrorHandler {

    @Resource
    KafkaProperties kafkaProperties;
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        log.error("当前异常信息为",exception);
        Map<String, String> properties = kafkaProperties.getProperties();
        // 接口返回值会被忽略，所以不需要处理
        return null;
    }
}
