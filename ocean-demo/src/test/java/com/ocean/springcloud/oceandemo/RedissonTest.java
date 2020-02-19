package com.ocean.springcloud.oceandemo;

//import org.redisson.Redisson;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.redisson.config.SingleServerConfig;

import java.util.concurrent.TimeUnit;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年09月11日 11:39
 */
public class RedissonTest {
    public static void main(String[] args) throws InterruptedException {
//        Config config = new Config();
//        SingleServerConfig singleServerConfig = config.useSingleServer();
//        singleServerConfig.setAddress("redis://39.108.9.37:7005");
//        RedissonClient redisson = Redisson.create(config);
//        RLock lock = redisson.getLock("lock");
//        lock.lock(2, TimeUnit.SECONDS);
//
//        Thread t = new Thread() {
//            public void run() {
//                RLock lock1 = redisson.getLock("lock");
//                lock1.lock();
//                lock1.unlock();
//            };
//        };
//
//        t.start();
//        t.join();
//        lock.unlock();
//
//        redisson.shutdown();
    }
}
