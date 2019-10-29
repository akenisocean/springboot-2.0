package com.ocean.springcloud.oceanpaydemo.pay.strategy;

/**
 * @author chao
 * @version 1.0
 * @desc 抽象统一的支付策略
 * @date 2019年09月11日 17:13
 */
@FunctionalInterface
public interface PayStrategy<R,T> {

    /**
     *
     * @param t
    支付策略抽象     * @return
     */
    R operate(T t);
}
