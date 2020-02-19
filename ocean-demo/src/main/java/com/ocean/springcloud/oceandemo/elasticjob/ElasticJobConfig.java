//package com.ocean.springcloud.oceandemo.elasticjob;
//
//import com.dangdang.ddframe.job.config.JobCoreConfiguration;
//import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
//import com.dangdang.ddframe.job.lite.api.JobScheduler;
//import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
//import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
//import lombok.Data;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PostConstruct;
//
///**
// * @author: chao
// * @description: elasticJob配置中心
// * @create: 2019-12-18 22:48
// */
//@Configuration
//@Data
//@ConfigurationProperties(prefix = "elasticjob.zookeeper")
//public class ElasticJobConfig {
//    /**
//     * zookeeper地址列表
//     */
//    private String serverlists;
//    /**
//     * zookeeper命名空间
//     */
//    private String namespace;
//
////    @PostConstruct
////    public void elasticJobConfig(){
////        new JobScheduler(zkCenter(),liteJobConfiguration()).init();
////    }
//
//    @Bean
//    public CoordinatorRegistryCenter zkCenter() {
//        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(serverlists, namespace);
//        ZookeeperRegistryCenter center = new ZookeeperRegistryCenter(zookeeperConfiguration);
//        center.init();
//        return center;
//    }
//
//    public static LiteJobConfiguration liteJobConfiguration() {
//        //job核心配置
//        JobCoreConfiguration jcc = JobCoreConfiguration.newBuilder("mySimpleJob", "0/5 * * * * ?", 2).build();
//        //job类型配置
//        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(jcc, MySimpleJob.class.getCanonicalName());
//        //job根配置
//        LiteJobConfiguration ljc = LiteJobConfiguration.newBuilder(simpleJobConfiguration).overwrite(true).build();
//        return ljc;
//
//
//    }
//}
