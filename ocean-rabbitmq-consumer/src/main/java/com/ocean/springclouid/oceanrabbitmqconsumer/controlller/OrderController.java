package com.ocean.springclouid.oceanrabbitmqconsumer.controlller;

import com.ocean.springclouid.oceanrabbitmqconsumer.entity.Order;
import com.ocean.springclouid.oceanrabbitmqconsumer.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Order createOrder(@RequestBody Order order) {
        try {
            orderService.createOrder(order);
        } catch (Exception e) {
            log.info("创建订单出错;{}", e);
            return new Order();
        }
        return order;
    }
}
