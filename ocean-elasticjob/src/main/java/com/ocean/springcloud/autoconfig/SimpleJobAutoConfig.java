package com.ocean.springcloud.autoconfig;

import com.dangdang.ddframe.job.api.ElasticJob;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
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
 * @description: 一般job自动配置
 * @create: 2020-04-05 21:41
 */
@Configuration
@ConditionalOnBean(CoordinatorRegistryCenter.class)
@AutoConfigureAfter(ZookeeperAutoConfig.class)
public class SimpleJobAutoConfig {

    @Autowired
    ApplicationContext applicationContext;

    @Resource
    CoordinatorRegistryCenter zkCenter;

    @PostConstruct
    public void initSimpleJob(){
        Map<String, Object> esSimpleJobBeans = applicationContext.getBeansWithAnnotation(ElasticSimpleJob.class);
        esSimpleJobBeans.forEach((key,value)->{
            //判断当前类中有无实现SimpleJob接口
            Class<?>[] interfaces = value.getClass().getInterfaces();
            for (Class<?> superInterface : interfaces) {
                if (superInterface == SimpleJob.class){
                    ElasticSimpleJob esSimpleJob = value.getClass().getAnnotation(ElasticSimpleJob.class);
                    String jobName = esSimpleJob.jobName();
                    String cron = esSimpleJob.cron();
                    int shardingTotalCount = esSimpleJob.shardingTotalCount();
                    boolean overwrite = esSimpleJob.overwrite();
                    JobCoreConfiguration jcc = JobCoreConfiguration.newBuilder(jobName, cron, shardingTotalCount).build();
                    SimpleJobConfiguration sjc = new SimpleJobConfiguration(jcc, value.getClass().getCanonicalName());
                    LiteJobConfiguration liteJobConfiguration = LiteJobConfiguration.newBuilder(sjc).overwrite(overwrite).build();
                    new SpringJobScheduler((ElasticJob) value,zkCenter,liteJobConfiguration).init();

                }
                
            }

        });

    }
}
