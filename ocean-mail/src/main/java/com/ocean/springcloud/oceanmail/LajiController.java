package com.ocean.springcloud.oceanmail;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chao
 * @description: 垃圾测试
 * @create: 2020-04-09 14:09
 */
@RestController
@RequestMapping("/laji")
public class LajiController {

    @PostMapping("/laji")
    public void laji(@RequestBody AlarmPlatformRequest request) {

    }
}
