package com.ocean.springcloud.oceandemo.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chao
 * @description: 重试测试
 * @create: 2020-02-27 17:46
 */
@RestController
@RequestMapping("/retryTest")
public class RetryTestController {
    @Autowired
    private RetryService retryService;

    @GetMapping("/minus1")
    public void retry() {
        int count = retryService.retry(-1);
        System.out.println("库存为 ：" + count);
    }
}
