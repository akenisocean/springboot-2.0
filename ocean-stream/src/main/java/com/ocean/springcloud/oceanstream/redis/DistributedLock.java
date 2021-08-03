package com.ocean.springcloud.oceanstream.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


public class DistributedLock {

  public static final int WAIT_TIME = 100;
  public static final int LEASE_TIME = 30;

  private RedissonClient redissonClient;

  public DistributedLock(RedissonClient redissonClient) {
    this.redissonClient = redissonClient;
  }

  public boolean tryLock(String lockName) {
    RLock rLock = redissonClient.getLock(lockName);
    return rLock.tryLock();
  }

  public boolean tryLock(String lockName, long time, TimeUnit unit) throws InterruptedException {
    RLock rLock = redissonClient.getLock(lockName);
    return rLock.tryLock(time, unit);
  }

  public boolean tryLock(String lockName, long waitTime, long leaseTime, TimeUnit unit)
      throws InterruptedException {
    RLock rLock = redissonClient.getLock(lockName);
    return rLock.tryLock(waitTime, leaseTime, unit);
  }

  public void unLock(String lockName) {
    RLock rLock = redissonClient.getLock(lockName);
    rLock.unlock();
  }

  public boolean isLocked(String lockName) {
    RLock rLock = redissonClient.getLock(lockName);
    return rLock.isLocked();
  }

  public void lockInterruptibly(String lockName, long leaseTime, TimeUnit unit)
      throws InterruptedException {
    RLock rLock = redissonClient.getLock(lockName);
    rLock.lockInterruptibly(leaseTime, unit);
  }

  public void lock(String lockName) {
    RLock rLock = redissonClient.getLock(lockName);
    rLock.lock();
  }

  public void lockInterruptibly(String lockName) throws InterruptedException {
    RLock rLock = redissonClient.getLock(lockName);
    rLock.lockInterruptibly();
  }

  public boolean forceUnlock(String lockName) {
    RLock rLock = redissonClient.getLock(lockName);
    return rLock.forceUnlock();
  }

  public boolean isHeldByThread(String lockName, long threadId) {
    RLock rLock = redissonClient.getLock(lockName);
    return rLock.isHeldByThread(threadId);
  }

  public boolean isHeldByCurrentThread(String lockName) {
    RLock rLock = redissonClient.getLock(lockName);
    return rLock.isHeldByCurrentThread();
  }

  public int getHoldCount(String lockName) {
    RLock rLock = redissonClient.getLock(lockName);
    return rLock.getHoldCount();
  }
}
