//package com.ocean.springcloud.oceandemo.elasticjob;
//
//import com.dangdang.ddframe.job.api.ShardingContext;
//import com.dangdang.ddframe.job.api.simple.SimpleJob;
//import lombok.extern.slf4j.Slf4j;
//
//import java.time.LocalTime;
//
///**
// * @author: chao
// * @description: 简单job
// * @create: 2019-12-18 22:41
// */
//@Slf4j
//public class MySimpleJob implements SimpleJob {
//    @Override
//    public void execute(ShardingContext shardingContext) {
//        LocalTime time = LocalTime.now();
//        log.info("当前分片项:{},总分片项:{},taskId:{}", shardingContext.getShardingItem(), shardingContext.getShardingTotalCount()
//                , shardingContext.getTaskId());
//    }
//}
