package com.ocean.springcloud.oceandemo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.core.ConfigConsts;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@SpringBootApplication
@EnableApolloConfig(value = {ConfigConsts.NAMESPACE_APPLICATION,"TEST1.jackchao"})
public class OceanDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OceanDemoApplication.class, args);
    }


    @Bean
    RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
       return  restTemplateBuilder.build();
    }

    @ApolloConfig
    private Config config; //inject config for namespace application


    @ApolloConfigChangeListener(value = {ConfigConsts.NAMESPACE_APPLICATION,"TEST1.jackchao"})
    private void configChangeListter(ConfigChangeEvent changeEvent) {
        refreshLoggingLevels();
    }

//    @PostConstruct
    private void refreshLoggingLevels() {
        Set<String> keyNames = config.getPropertyNames();
        keyNames.forEach(System.out::println);
//        for (String key : keyNames) {
//            if (StringUtils.containsIgnoreCase(key, LOGGER_TAG)) {
//                String strLevel = config.getProperty(key, "info");
//                LogLevel level = LogLevel.valueOf(strLevel.toUpperCase());
//                loggingSystem.setLogLevel(key.replace(LOGGER_TAG, ""), level);
//                logger.info("{}:{}", key, strLevel);
//            }
//        }
    }








}
