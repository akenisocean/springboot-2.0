package com.ocean.springcloud.oceanelasticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.ocean.springcloud.autoconfig.ElasticSimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: chao
 * @description:
 * @create: 2020-04-06 22:35
 */
@ElasticSimpleJob(jobName = "thrid_order_producer",cron = "0/5 * * * * ?", shardingTotalCount = 1,overwrite = true)
@Component
@Slf4j
public class ThridOrderProducerJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {

    }
}
