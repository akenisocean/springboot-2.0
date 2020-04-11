package com.ocean.springcloud.oceanelasticjob.service;

import com.ocean.springcloud.oceanelasticjob.dao.OrderDao;
import com.ocean.springcloud.oceanelasticjob.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: chao
 * @description: 订单服务
 * @create: 2020-04-06 17:37
 */
@Service
@Slf4j
public class OrderService {

    @Autowired
    OrderDao orderDao;

    @PostConstruct
    public List<Order> getAll(){
        List<Order> orders = orderDao.findAll();
        return orders;
    }

    public boolean insertOrder(Order order){
        orderDao.save(order);
        return true;
    }

}
