package com.ocean.springclouid.druidmybatismultiple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chao
 * @version 1.0
 * @desc 时间controller层
 * @date 2019年04月08日 13:25
 */
@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/blackEvent")
    public void blackEvent() {
        emailService.sendEmail("known.spammer@example.org", "你傻逼了");

    }
}
