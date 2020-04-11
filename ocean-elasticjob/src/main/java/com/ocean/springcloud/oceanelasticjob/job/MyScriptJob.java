package com.ocean.springcloud.oceanelasticjob.job;

import com.dangdang.ddframe.job.api.script.ScriptJob;
import com.ocean.springcloud.autoconfig.ElasticDatafowJob;
import com.ocean.springcloud.autoconfig.ElasticScriptJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: chao
 * @description: 脚本调度
 * @create: 2020-04-05 23:51
 */

//@ElasticScriptJob(jobName = "myScriptJob",cron = "*/3 * * * * ?", shardingTotalCount = 2)
@Component
@Slf4j
public class MyScriptJob implements ScriptJob {
}
