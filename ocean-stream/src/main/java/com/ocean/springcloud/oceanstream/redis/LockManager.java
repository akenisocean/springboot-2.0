package com.ocean.springcloud.oceanstream.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

/**
 * @author chao
 * @description
 * @create 2021-07-03 15:07
 */
@Component
public class LockManager {
    public static final String ERROR_QUEUE_INSERT = "lock:task:%d:eq-insert:%s";
    public static final String ERROR_QUEUE_OPERATION = "lock:task:%d:eq-operation";
    public static final String PIPELINE_OPERATION = "lock:task:%d:pipeline-operation";
    public static final String DATA_SOURCE_OPERATION = "lock:datasource:%d:datasource-operation";
    public static final String DATA_SOURCE_DETAIL_OPERATION = "lock:datasource:%d:%s:datasource-detail-operation";
    public static final String DATA_DESTINATION_OPERATION = "lock:destination:%d:destination-operation";
    public static final String DATA_SERVICE_OPERATION = "lock:data-service:%d:service-operation";
    private final DistributedLock distributedLock;

    public LockManager(RedissonClient redisson) {
        this.distributedLock = new DistributedLock(redisson);
    }

    public boolean tryLock(String lockName) {
        Assert.hasText(lockName, "lockName");

        try {
            return distributedLock.tryLock(lockName, 100L, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void unLock(String lockName) {
        Assert.hasText(lockName, "lockName");
        distributedLock.unLock(lockName);
    }

    public boolean isLocked(String lockName) {
        Assert.hasText(lockName, "lockName");
        return distributedLock.isLocked(lockName);
    }
}

