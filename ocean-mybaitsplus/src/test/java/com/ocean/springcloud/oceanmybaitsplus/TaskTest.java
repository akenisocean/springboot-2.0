package com.ocean.springcloud.oceanmybaitsplus;

import com.ocean.springcloud.oceanmybaitsplus.config.schedule.CronTaskRegistrar;
import com.ocean.springcloud.oceanmybaitsplus.config.schedule.SchedulingRunnable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: chao
 * @description: 测试定时任务
 * @create: 2020-02-11 13:59
 */
@SpringBootTest(classes = OceanMybaitsplusApplication.class)
public class TaskTest {

    @Autowired
    CronTaskRegistrar cronTaskRegistrar;

    @Test
    public void testTask() throws InterruptedException {
        SchedulingRunnable task = new SchedulingRunnable("demoTask", "taskNoParams", null);
        cronTaskRegistrar.addCronTask(task, "0/10 * * * * ?");

        // 便于观察
        Thread.sleep(3000000);
    }

    @Test
    public void testHaveParamsTask() throws InterruptedException {
        SchedulingRunnable task = new SchedulingRunnable("demoTask", "taskWithParams", "haha", 23);
        cronTaskRegistrar.addCronTask(task, "0/10 * * * * ?");

        // 便于观察
        Thread.sleep(3000000);
    }
}