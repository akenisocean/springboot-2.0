package com.ocean.springcloud.oceanfeignconsumer.feign;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 季超
 * @create 2018-12-21 15:59
 * @desc
 **/
@Configuration
public class FeignDefaultConfiguration {


    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("ocean","ocean");
    }
}
