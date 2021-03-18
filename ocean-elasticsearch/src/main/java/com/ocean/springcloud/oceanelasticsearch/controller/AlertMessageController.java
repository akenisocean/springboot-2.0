package com.ocean.springcloud.oceanelasticsearch.controller;

import com.ocean.springcloud.oceanelasticsearch.model.AlertMessage;
import com.ocean.springcloud.oceanelasticsearch.service.AlertMessageService;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: chao
 * @description:
 * @create: 2020-12-05 23:48
 */
@RestController
@RequestMapping("/alertMessage")
public class AlertMessageController {

    @Resource
    AlertMessageService alertMessageService;

    @Resource
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @PostMapping("/insert")
    public List<AlertMessage> insert(@RequestBody List<AlertMessage> alertMessageList) {
        return alertMessageService.insertAlertMessage(alertMessageList);
    }

    @GetMapping("/get/{id}")
    public AlertMessage getById(@PathVariable("id")String id){
        return alertMessageService.getById(id);
    }


    @PostMapping("/update")
    public AlertMessage update(@RequestBody AlertMessage alertMessage){
        return alertMessageService.uapdate(alertMessage);
    }

    @GetMapping("/searchAllAlertMessage")
    public List<AlertMessage> searchAllAlertMessage(){
        return alertMessageService.searchAllAlertMessage();
    }
}
