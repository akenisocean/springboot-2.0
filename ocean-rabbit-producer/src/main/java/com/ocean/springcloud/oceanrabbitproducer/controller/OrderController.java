package com.ocean.springcloud.oceanrabbitproducer.controller;

import com.ocean.springcloud.oceanrabbitproducer.entity.Order;
import com.ocean.springcloud.oceanrabbitproducer.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author chao
 * @version 1.0
 * @desc 订单Controller层
 * @date 2019年05月30日 11:10
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public Order createOrder(/*@RequestBody Order order*/) {
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setName(Thread.currentThread().getName());
        order.setMessageId(UUID.randomUUID().toString());
        try {
            orderService.createOrder(order);
        } catch (Exception e) {
            log.error("创建订单出错;{}", e);
            return new Order();
        }
        return order;
    }
}
