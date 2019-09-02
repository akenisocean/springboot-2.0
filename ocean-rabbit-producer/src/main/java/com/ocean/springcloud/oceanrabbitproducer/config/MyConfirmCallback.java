package com.ocean.springcloud.oceanrabbitproducer.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ocean.springcloud.oceanrabbitproducer.constants.MQConstants;
import com.ocean.springcloud.oceanrabbitproducer.constants.RabbitMetaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年08月01日 17:13
 */
@Slf4j
public class MyConfirmCallback implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    // ObjectMapper的作用是将Java对象转换成json对象和xml文档，同样也可以将json、xml转换成Java对象
    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.debug("confirm回调，ack={} correlationData={} cause={}", ack, correlationData, cause);

        String cacheKey = correlationData.getId();
        RabbitMetaMessage metaMessage = (RabbitMetaMessage) redisTemplate.opsForHash().get(MQConstants.MQ_PRODUCER_RETRY_KEY, cacheKey);
        // 只要消息能投入正确的交换器中，ack就为true
        if (ack) {
            if (!metaMessage.isReturnCallback()) {
                log.info("消息已正确投递到队列，correlationData:{}", correlationData);
                // 清除重发缓存
                redisTemplate.opsForHash().delete(MQConstants.MQ_PRODUCER_RETRY_KEY, cacheKey);
            } else {
                log.warn("交换机投机消息至队列失败，correlationData:{}", correlationData);
            }
        } else {
            log.error("消息投递至交换机失败，correlationData:{}，原因：{}", correlationData, cause);
            if (!metaMessage.isAutoTrigger()) {
                metaMessage.setAutoTrigger(true);
                try {
                    redisTemplate.opsForHash().put(MQConstants.MQ_PRODUCER_RETRY_KEY, cacheKey, objectMapper.writeValueAsString(metaMessage));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
