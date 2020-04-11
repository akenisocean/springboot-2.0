package com.ocean.springcloud.oceankafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: chao
 * @description:
 * @create: 2020-02-15 18:03
 */
@Controller
public class KafkaTestController {


    @Autowired
    private KfkaProducer producer;

    @PostMapping("/testSendMsg")
    @ResponseBody
    public String testSendMsg(String test){
        producer.send(test);
        return "success";
    }
}
