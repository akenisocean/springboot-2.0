package com.ocean.springcloud.autoconfig;

import com.dangdang.ddframe.job.api.script.ScriptJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.script.ScriptJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: chao
 * @description: 脚本job
 * @create: 2020-04-05 21:41
 */
@Configuration
@ConditionalOnBean(CoordinatorRegistryCenter.class)
@AutoConfigureAfter(ZookeeperAutoConfig.class)
public class ScriptJobAutoConfig {

    @Autowired
    ApplicationContext applicationContext;

    @Resource
    CoordinatorRegistryCenter zkCenter;

    @PostConstruct
    public void initScriptJob(){
        Map<String, Object> esScriptJobBeans = applicationContext.getBeansWithAnnotation(ElasticScriptJob.class);
        esScriptJobBeans.forEach((key,value)->{
            //判断当前类中有无实现SimpleJob接口
            Class<?>[] interfaces = value.getClass().getInterfaces();
            for (Class<?> superInterface : interfaces) {
                if (superInterface == ScriptJob.class){
                    ElasticScriptJob esScriptJob = value.getClass().getAnnotation(ElasticScriptJob.class);
                    String jobName = esScriptJob.jobName();
                    String cron = esScriptJob.cron();
                    int shardingTotalCount = esScriptJob.shardingTotalCount();
                    boolean overwrite = esScriptJob.overwrite();
                    JobCoreConfiguration jcc = JobCoreConfiguration.newBuilder(jobName, cron, shardingTotalCount).build();
                    ScriptJobConfiguration sjc = new ScriptJobConfiguration(jcc, "/Users/happygiraffe/Desktop/scriptjob-test.sh");
                    LiteJobConfiguration liteJobConfiguration = LiteJobConfiguration.newBuilder(sjc).overwrite(overwrite).build();
                    new JobScheduler(zkCenter,liteJobConfiguration).init();

                }

            }

        });

    }
}
