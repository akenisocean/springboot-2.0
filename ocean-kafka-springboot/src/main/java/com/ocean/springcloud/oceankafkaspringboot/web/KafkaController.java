package com.ocean.springcloud.oceankafkaspringboot.web;

import com.ocean.springcloud.oceankafkaspringboot.producer.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author: chao
 * @description:
 * @create: 2020-10-16 16:23
 */
@Slf4j
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final KafkaProducer producer;

    @Autowired
    KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }

    @PostMapping(value = "/publisherrors")
    public void sendMessageToKafkaErrorTopic(@RequestParam("message") String message) {
        this.producer.sendErrorMessage(message);
    }

    @PostConstruct
    public void test() {
        String message = "jackchao123asdadddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    log.info("停止线程池错误", e);
                }
                producer.sendMessage(message);
            }
        }).start();

    }
}