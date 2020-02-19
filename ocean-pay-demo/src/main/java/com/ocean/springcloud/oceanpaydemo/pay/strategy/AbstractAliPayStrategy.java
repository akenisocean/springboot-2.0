package com.ocean.springcloud.oceanpaydemo.pay.strategy;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.ocean.springcloud.oceanpaydemo.pay.config.AliPayConfig;
import com.ocean.springcloud.oceanpaydemo.pay.config.ApiUrlConstants;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年09月19日 15:31
 */
@Getter
public abstract class AbstractAliPayStrategy<R, T> implements PayStrategy<R, T> {

    @Autowired
    private AliPayConfig aliPayConfig;

    /**
     * 支付宝验签操作
     *
     * @param params
     * @param sign
     */
    public void aliPayCheckSign(String params, String sign) {
        try {
            boolean rsaCheck = AlipaySignature.rsaCheck(params, sign, aliPayConfig.getAlipayPublicKey(), ApiUrlConstants.AliPayConstants.DEFAULT_CHARSET, ApiUrlConstants.AliPayConstants.DEFAULT_SIGN_TYPE);
            if (!rsaCheck) {

            }
        } catch (AlipayApiException e) {
        }


    }


}
