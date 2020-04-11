package com.ocean.springcloud.autoconfig;

import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: chao
 * @description: zookeeper自动配置
 * @create: 2020-04-05 00:10
 */
@Configuration
@ConditionalOnProperty("ocean.elasitcjob.zookeeper.server-list")
@EnableConfigurationProperties(ZookeeperProperties.class)
public class ZookeeperAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public ZookeeperProperties zookeeperProperties() {
        return new ZookeeperProperties();
    }

    @Bean(initMethod = "init")
    public CoordinatorRegistryCenter zkCenter(){
        ZookeeperRegistryCenter zookeeperRegistryCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration(zookeeperProperties().getServerList(), zookeeperProperties().getNamespace()));
        return zookeeperRegistryCenter;
    }



}
