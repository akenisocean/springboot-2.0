package com.ocean.springcloud.oceanmybaitsplus.config.schedule;

import java.util.concurrent.ScheduledFuture;

/**
 * @author: chao
 * @description: 定时任务控制类
 * @create: 2020-02-11 13:41
 */
public final class ScheduledTask {

    volatile ScheduledFuture future;

    /**
     * 取消定时任务
     */
    public void cancel() {
        ScheduledFuture future = this.future;
        if (future != null) {
            future.cancel(true);
        }
    }
}
