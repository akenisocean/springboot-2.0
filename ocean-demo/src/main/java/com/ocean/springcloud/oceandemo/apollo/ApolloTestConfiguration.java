package com.ocean.springcloud.oceandemo.apollo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: chao
 * @description: apollo客户端配置
 * @create: 2019-12-13 16:21
 */
@Component
@ConfigurationProperties(prefix = "test")
@Getter
@Setter
public class ApolloTestConfiguration {

    private String test1;
    private String test2;
    private String test3;
}
