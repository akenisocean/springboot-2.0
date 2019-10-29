package com.ocean.springcloud.oceanpaydemo.pay.config;

/**
 * @author chao
 * @version 1.0
 * @desc pay url collection
 * @date 2019年09月12日 12:40
 */
public interface ApiUrlConstants {


    /**
     * Wechat Pay Common Url
     */
    interface WxPayConstants {
        String BAT_CODE_PAYMENT_URL = "https://api.mch.weixin.qq.com/pay/micropay";
        String DEFAULT_SIGN_TYPE = "MD5";
    }

    /**
     * AliPay Common Url
     */
    interface AliPayConstants {
        String BAT_CODE_PAYMENT_URL = "https://openapi.alipay.com/gateway.do";
        String DEFAULT_CHARSET = "UTF-8";
        String DEFAULT_FORMAT = "json";
        String DEFAULT_SIGN_TYPE = "RSA2";
    }

}
