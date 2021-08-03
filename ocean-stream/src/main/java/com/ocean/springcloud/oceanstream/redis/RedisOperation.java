package com.ocean.springcloud.oceanstream.redis;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RKeys;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author chao
 * @description
 * @create 2021-07-02 17:30
 */
@Slf4j
@RestController
public class RedisOperation {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Resource
    LockManager lockManager;

    @GetMapping("/redisLock")
    public void operation1() {
        String jack = "jackchao2";
        String lockName = String.format("lock:task:%s:pipeline-operation", jack);

        log.info("开始redis分布式锁操作");
        log.info("当前是否锁住:{}", lockManager.isLocked(lockName) ? "锁住了" : "未锁住");
        boolean isLock = lockManager.tryLock(lockName);
        if (!isLock) {
            log.error("当前redis分布式锁在等待");
        } else {
//                    log.info("开始执行任务");
            try {
                log.info("开始执行任务");
                TimeUnit.SECONDS.sleep(10);
                log.info("任务执行正常完成");
            } catch (InterruptedException e) {
                log.error("睡眠失败", e);
            } finally {
                log.info("开始解锁操作了");
                lockManager.unLock(lockName);
            }
        }
    }


}
