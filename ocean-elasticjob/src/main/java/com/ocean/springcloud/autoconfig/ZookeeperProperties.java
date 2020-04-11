package com.ocean.springcloud.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author: chao
 * @description: zookeeper配置
 * @create: 2020-04-04 23:52
 */
@Validated
@ConfigurationProperties(prefix = "ocean.elasitcjob.zookeeper")
public class ZookeeperProperties {
    @NotNull
    /**
     * zookeeper地址列表
     */
    private String serverList = "localhost:2181";

    /**
     * zookeeper命名空间
     */
    private String namespace;


    public String getServerList() {
        return serverList;
    }

    public void setServerList(String serverList) {
        this.serverList = serverList;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
