package com.ocean.springcloud.oceanelasticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.ocean.springcloud.autoconfig.ElasticSimpleJob;
import com.ocean.springcloud.oceanelasticjob.entity.Order;
import com.ocean.springcloud.oceanelasticjob.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: chao
 * @description:
 * @create: 2020-04-04 21:30
 */

@ElasticSimpleJob(jobName = "mySimpleJob",cron = "0/5 * * * * ?", shardingTotalCount = 1,overwrite = true)
@Component
@Slf4j
public class MySimpleJob implements SimpleJob {

    @Autowired
    OrderService orderService;
    @Override
    public void execute(ShardingContext shardingContext) {
        for (int x = 0 ;x < 10;x++){
            Order order = Order.builder().status(1)
                    .amount(new BigDecimal("23.33"))
                    .createTime(new Date())
                    .createUser("dachao")
                    .updateTime(new Date())
                    .updateUser("dachao")
                    .receiveMobile("18675765390")
                    .receiveAddress("上海市徐汇区华沁家园小区")
                    .receiveName("果子")
                    .build();
            orderService.insertOrder(order);
        }


//        switch (shardingContext.getShardingItem()) {
//            case 0:
//                System.out.println("hello from shard 0");
//                break;
//            case 1:
//                System.out.println("hello from shard 1");
//                break;
//        }
    }
}
