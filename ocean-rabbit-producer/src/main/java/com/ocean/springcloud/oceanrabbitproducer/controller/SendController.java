package com.ocean.springcloud.oceanrabbitproducer.controller;

import com.ocean.springcloud.oceanrabbitproducer.bean.ResponseEntity;
import com.ocean.springcloud.oceanrabbitproducer.config.MyConfirmCallback;
import com.ocean.springcloud.oceanrabbitproducer.config.MyReturnCallback;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 消息接口.
 *
 * @author dax.
 * @version v1.0
 * @since 2018 /2/23 17:27
 */
@RestController
@RequestMapping("/rabbit")
public class SendController {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private MyConfirmCallback myConfirmCallback;

    @Resource
    private MyReturnCallback myReturnCallback;

    /**
     * 测试广播模式.
     *
     * @param p the p
     * @return the response entity
     */
    @RequestMapping("/fanout")
    public ResponseEntity send(String p) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());

        rabbitTemplate.convertAndSend("FANOUT_EXCHANGE", "", p, correlationData);
        return ResponseEntity.ok();
    }

    /**
     * 测试Direct模式.
     *
     * @param p the p
     * @return the response entity
     */
    @RequestMapping("/direct/{p}")
    public ResponseEntity direct(@PathVariable("p") String p) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("DIRECT_EXCHANGE", "DIRECT_ROUTING_KEY2", p, correlationData);
        return ResponseEntity.ok();
    }

    /**
     * 测试死信队列.
     *
     * @param p the p
     * @return the response entity
     */
    @RequestMapping("/dead")
    public ResponseEntity deadLetter(String p) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
//        声明消息处理器  这个对消息进行处理  可以设置一些参数   对消息进行一些定制化处理   我们这里  来设置消息的编码  以及消息的过期时间  因为在.net 以及其他版本过期时间不一致   这里的时间毫秒值 为字符串
        MessagePostProcessor messagePostProcessor = message -> {
            MessageProperties messageProperties = message.getMessageProperties();
//            设置编码
            messageProperties.setContentEncoding("utf-8");
//            设置过期时间10*1000毫秒
            messageProperties.setExpiration("10000");
            return message;
        };
//         向DL_QUEUE 发送消息  10*1000毫秒后过期 形成死信
        rabbitTemplate.convertAndSend("DL_EXCHANGE", "DL_KEY", p, messagePostProcessor, correlationData);
        return ResponseEntity.ok();
    }
}
