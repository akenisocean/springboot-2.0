package com.ocean.springclouid.oceanrabbitmqconsumer.service;

import com.ocean.springclouid.oceanrabbitmqconsumer.constant.Constants;
import com.ocean.springclouid.oceanrabbitmqconsumer.entity.BrokerMessageLog;
import com.ocean.springclouid.oceanrabbitmqconsumer.entity.Order;
import com.ocean.springclouid.oceanrabbitmqconsumer.mapper.BrokerMessageLogMapper;
import com.ocean.springclouid.oceanrabbitmqconsumer.mapper.OrderMapper;
import com.ocean.springclouid.oceanrabbitmqconsumer.producer.RabbitOrderSender;
import com.ocean.springclouid.oceanrabbitmqconsumer.utils.FastJsonConvertUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;

    @Autowired
    private RabbitOrderSender rabbitOrderSender;


    public void createOrder(Order order) throws Exception {
        // order current time
        Date orderTime = new Date();
        // order insert
        orderMapper.insert(order);
        // log insert
        BrokerMessageLog brokerMessageLog = new BrokerMessageLog();
        brokerMessageLog.setMessageId(order.getMessageId());
        //save order message as json
        brokerMessageLog.setMessage(FastJsonConvertUtil.convertObjectToJSON(order));
        brokerMessageLog.setStatus("0");
        brokerMessageLog.setNextRetry(DateUtils.addMinutes(orderTime, Constants.ORDER_TIMEOUT));
        brokerMessageLog.setCreateTime(new Date());
        brokerMessageLog.setUpdateTime(new Date());
        brokerMessageLogMapper.insert(brokerMessageLog);
        // order message sender
        rabbitOrderSender.sendOrder(order);
    }

}
