package com.ocean.springcloud.oceanrabbitproducer.service;

import com.alibaba.fastjson.JSON;
import com.ocean.springcloud.oceanrabbitproducer.entity.BrokerMessageLog;
import com.ocean.springcloud.oceanrabbitproducer.entity.Order;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年08月09日 16:03
 */
@Service
public class OrderService {

    private Map<String, Order> orderInsertMap = new ConcurrentHashMap<>();
    private Map<String, BrokerMessageLog> orderMessageLogMap = new ConcurrentHashMap<>();

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void createOrder(Order order) {
        orderInsertMap.put(order.getId(), order);
        BrokerMessageLog brokerMessageLog = getBrokerMessageLog(order);
        orderMessageLogMap.put(brokerMessageLog.getMessageId(), brokerMessageLog);
        //消息唯一ID
        CorrelationData correlationData = new CorrelationData(order.getMessageId());
        rabbitTemplate.convertAndSend("DIRECT_EXCHANGE", "DIRECT_ROUTING_KEY", order, correlationData);
    }

    private BrokerMessageLog getBrokerMessageLog(Order order) {
        // order current time
        Date orderTime = new Date();
        // log insert
        BrokerMessageLog brokerMessageLog = new BrokerMessageLog();
        brokerMessageLog.setMessageId(order.getMessageId());
        //save order message as json
        brokerMessageLog.setMessage(JSON.toJSONString(order));
        brokerMessageLog.setStatus("0");
        brokerMessageLog.setNextRetry(DateUtils.addMinutes(orderTime, 1));
        brokerMessageLog.setCreateTime(new Date());
        brokerMessageLog.setUpdateTime(new Date());
        return brokerMessageLog;
    }
}
