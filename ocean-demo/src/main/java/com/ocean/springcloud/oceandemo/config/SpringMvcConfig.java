package com.ocean.springcloud.oceandemo.config;

import com.ocean.springcloud.oceandemo.controller.幂等测试.ApiIdempotentInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chao
 * @version 1.0
 * @desc springmvc配置
 * @date 2019年08月15日 15:20
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加自定义的拦截器
        registry.addInterceptor(apiIdempotentInterceptor());
    }
    @Bean
    public ApiIdempotentInterceptor apiIdempotentInterceptor(){
        return new ApiIdempotentInterceptor();
    }
}
