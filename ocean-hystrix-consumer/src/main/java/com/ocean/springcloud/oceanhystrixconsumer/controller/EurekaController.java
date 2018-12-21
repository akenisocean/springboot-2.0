package com.ocean.springcloud.oceanhystrixconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 季超
 * @create 2018-12-20 15:57
 * @desc
 **/
@RestController

public class EurekaController {



    @Autowired
    private EurekaInstanceConfigBean eurekaInstanceConfigBean;


    @GetMapping("/getEurekaMetadata")
    public  Map<String, String> getEurekaMetadata(){
        Map<String, String> metadataMap = eurekaInstanceConfigBean.getMetadataMap();
        String instanceId = eurekaInstanceConfigBean.getInstanceId();
        System.out.println(instanceId);
        return metadataMap;
    }
}
