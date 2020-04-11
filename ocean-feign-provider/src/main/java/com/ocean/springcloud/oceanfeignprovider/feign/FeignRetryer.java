package com.ocean.springcloud.oceanfeignprovider.feign;

import feign.RetryableException;
import feign.Retryer;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author: chao
 * @description: feign重试配置
 * @create: 2020-03-03 15:43
 */
public class FeignRetryer implements Retryer{
    private final int maxAttempts;
    private final long period;
    private final long maxPeriod;
    int attempt;
    long sleptForMillis;

    public FeignRetryer() {
        this(100, SECONDS.toMillis(1), 3);
    }

    /**
     *
     * @param period 请求重试的间隔算法参数 默认100
     * @param maxPeriod 请求间隔最大时间 1秒
     * @param maxAttempts 最大重试次数 这里3次
     */
    public FeignRetryer(long period, long maxPeriod, int maxAttempts) {
        this.period = period;
        this.maxPeriod = maxPeriod;
        this.maxAttempts = maxAttempts;
        this.attempt = 1;
    }

    // visible for testing;
    protected long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override
    public void continueOrPropagate(RetryableException e) {
        if (attempt++ >= maxAttempts) {
            throw e;
        }

        long interval;
        if (e.retryAfter() != null) {
            interval = e.retryAfter().getTime() - currentTimeMillis();
            if (interval > maxPeriod) {
                interval = maxPeriod;
            }
            if (interval < 0) {
                return;
            }
        } else {
            interval = nextMaxInterval();
        }
        try {
            Thread.sleep(interval);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
            throw e;
        }
        sleptForMillis += interval;
    }

    /**
     * Calculates the time interval to a retry attempt. <br>
     * The interval increases exponentially with each attempt, at a rate of nextInterval *= 1.5
     * (where 1.5 is the backoff factor), to the maximum interval.
     *
     * @return time in nanoseconds from now until the next attempt.
     */
    long nextMaxInterval() {
        long interval = (long) (period * Math.pow(1.5, attempt - 1));
        return interval > maxPeriod ? maxPeriod : interval;
    }

    @Override
    public Retryer clone() {
        return new Retryer.Default(period, maxPeriod, maxAttempts);
    }

}
