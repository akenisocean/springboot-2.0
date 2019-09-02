package com.ocean.springcloud.oceanrabbitproducer.config;

import com.ocean.springcloud.oceanrabbitproducer.constants.MQConstants;
import com.ocean.springcloud.oceanrabbitproducer.constants.RabbitMetaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年08月01日 17:00
 */
@Slf4j
public class MyReturnCallback implements RabbitTemplate.ReturnCallback {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        String cacheKey = message.getMessageProperties().getMessageId();

        log.error("return回调，没有找到任何匹配的队列！message id:{},replyCode{},replyText:{},"
                + "exchange:{},routingKey{}", cacheKey, replyCode, replyText, exchange, routingKey);

        RabbitMetaMessage metaMessage = (RabbitMetaMessage) redisTemplate.opsForHash().get(MQConstants.MQ_PRODUCER_RETRY_KEY, cacheKey);

        metaMessage.setReturnCallback(true);

        // 由于amqp奇葩协议规定，return比confirm先回调
        redisTemplate.opsForHash().put(MQConstants.MQ_PRODUCER_RETRY_KEY, cacheKey, metaMessage);
    }
}
