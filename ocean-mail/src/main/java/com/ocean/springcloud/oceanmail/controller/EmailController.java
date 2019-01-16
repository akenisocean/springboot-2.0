package com.ocean.springcloud.oceanmail.controller;

import com.ocean.springcloud.oceanmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack chao
 * @create 2019-01-10 17:23
 * @desc
 **/
@RestController
@RequestMapping("/emailDevice")
public class EmailController {
    @Autowired
    private MailService mailService;
    @GetMapping("/sendEmail")
    public Map<String,String> sendEmail(){
        mailService.sendSimpleMail("akenisocean164214878@gmail.com","这是我的第一份邮件",
                "springboot发送的第一份邮件");
        HashMap<String, String> ma = new HashMap<>();
        ma.put("chenggong","111}");
        return ma;
    }
}
