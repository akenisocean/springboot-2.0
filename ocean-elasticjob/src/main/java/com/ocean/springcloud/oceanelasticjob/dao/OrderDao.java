package com.ocean.springcloud.oceanelasticjob.dao;

import com.ocean.springcloud.oceanelasticjob.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: chao
 * @description:
 * @create: 2020-04-06 17:37
 */
@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {
}
