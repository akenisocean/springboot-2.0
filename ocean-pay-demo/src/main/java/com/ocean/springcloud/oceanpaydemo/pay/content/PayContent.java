package com.ocean.springcloud.oceanpaydemo.pay.content;


import com.ocean.springcloud.oceanpaydemo.pay.strategy.PayStrategy;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/26 上午11:16
 */
public class PayContent<R, T> {

    private PayStrategy<R, T> payStrategy;

    public PayContent(PayStrategy<R, T> payStrategy) {
        this.payStrategy = payStrategy;
    }

    public R execute(T t) {

        return payStrategy.operate(t);
    }
}
