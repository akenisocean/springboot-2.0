package com.ocean.springcloud.oceanthirddemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: chao
 * @description: 腾讯短信发送controller层
 * @create: 2020-02-24 14:53
 */
@RestController
@RequestMapping("/sms")
public class TQSMSController {

    @GetMapping("/sendSms/{phone}")
    public Map<String,String> sendSms(@PathVariable("phone")String phone){
        SmsMedium smsService = new SmsMedium();
        ArrayList<String> phones = new ArrayList<>();
        phones.add(phone);
        ArrayList<String> params = new ArrayList<>();
        params.add("告警");
        params.add("严重");
        params.add("wanke");
        params.add("192.168.3.4");
        params.add("资源监控");
        params.add("CPU负荷运载");
        params.add("");
        params.add("2020/1/15 11:22");
        params.add("2020/1/15 11:30");
        smsService.smsMuiltiSend(phones,params);
        Map<String, String> map = new HashMap<>();
        map.put("phone",phone);
        return map;
    }

}
