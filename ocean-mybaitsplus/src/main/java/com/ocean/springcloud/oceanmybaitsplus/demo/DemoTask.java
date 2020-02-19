package com.ocean.springcloud.oceanmybaitsplus.demo;

import org.springframework.stereotype.Component;

/**
 * @author: chao
 * @description:
 * @create: 2020-02-11 13:57
 */
@Component("demoTask")
public class DemoTask {
    public void taskWithParams(String param1, Integer param2) {
        System.out.println("这是有参示例任务：" + param1 + param2);
    }

    public void taskNoParams() {
        System.out.println("这是无参示例任务");
    }
}
