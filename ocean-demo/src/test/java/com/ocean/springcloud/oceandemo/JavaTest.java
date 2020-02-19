package com.ocean.springcloud.oceandemo;

import org.junit.Test;

import java.util.Optional;

/**
 * @author chao
 * @version 1.0
 * @desc java测试
 * @date 2019年10月15日 15:11
 */
public class JavaTest {
    @Test
    public void optionalTest() {
        CouponConfQrReq c = new CouponConfQrReq();
        Optional<CouponConfQrReq> op = Optional.ofNullable(c);
        System.out.println();

    }
}
