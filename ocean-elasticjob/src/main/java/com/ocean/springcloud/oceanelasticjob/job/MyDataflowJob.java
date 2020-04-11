package com.ocean.springcloud.oceanelasticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.ocean.springcloud.autoconfig.ElasticDatafowJob;
import com.ocean.springcloud.oceanelasticjob.entity.Order;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author: chao
 * @description: 100条数据未处理，每次抓取10条数据进行处理，更行状态为已处理。
 * @create: 2020-04-05 23:00
 */
//@ElasticDatafowJob(jobName = "myDataflowJob",cron = "*/3 * * * * ?", shardingTotalCount = 2)
@Slf4j
@Component
public class MyDataflowJob implements DataflowJob<Order> {

    private List<Order> orders = new ArrayList<>();

    {
        for (int x = 0; x < 100 ;x++){
            orders.add(Order.builder().id(x+1).status(0).build());
        }
    }


    @SneakyThrows
    @Override
    public List<Order> fetchData(ShardingContext shardingContext) {
        //订单号 % 分片总数 == 当前总分片项
        List<Order> orderList = orders.stream().filter(order -> order.getStatus().equals(0)).
                filter(order -> order.getId() % shardingContext.getShardingTotalCount() == shardingContext.getShardingItem())
                .collect(Collectors.toList());
        List<Order> subOrderList = null;
        if (Objects.nonNull(orderList) && !orderList.isEmpty()){
           subOrderList = orderList.subList(0, 10);
        }
        TimeUnit.SECONDS.sleep(3);
        List<Order> orders = Optional.ofNullable(subOrderList).orElse(new ArrayList<>());
        log.info("我是分片项:{},我抓取的数据是:{}",shardingContext.getShardingItem(),orders.toString());
        return orders;
    }

    @SneakyThrows
    @Override
    public void processData(ShardingContext shardingContext, List<Order> data) {
        data.forEach(order -> order.setStatus(1));
        log.info("我是分片项:{},我正在处理数据！",shardingContext.getShardingItem(),orders.toString());
        TimeUnit.SECONDS.sleep(5);
    }
}
