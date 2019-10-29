package com.ocean.springcloud.oceanpaydemo.pay.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author chao
 * @version 1.0
 * @desc 支付宝配置
 * @date 2019年09月11日 18:00
 */
@Component
@ConfigurationProperties(prefix = "alipay")
@Data
public class AliPayConfig {
    private String alipayalipayId;
    private String alipayKey;
    private String alipayPublicKey;
    private String alipaySeller;
    private String alipayCallback;
    private String alipayRefundCallback;


    /**
     * 获取AlipayClient对象
     *
     * @return
     */
    private AlipayClient alipayClient;

    @PostConstruct
    public void init() {
        alipayClient = new DefaultAlipayClient(ApiUrlConstants.AliPayConstants.BAT_CODE_PAYMENT_URL, alipayalipayId, alipayKey,
                ApiUrlConstants.AliPayConstants.DEFAULT_FORMAT, ApiUrlConstants.AliPayConstants.DEFAULT_CHARSET, alipayPublicKey, ApiUrlConstants.AliPayConstants.DEFAULT_SIGN_TYPE);

    }

}



