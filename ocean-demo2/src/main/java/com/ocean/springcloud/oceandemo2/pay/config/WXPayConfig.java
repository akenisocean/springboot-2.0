package com.ocean.springcloud.oceandemo2.pay.config;

import lombok.Data;
import lombok.ToString;

/**
 * @author chao
 * @version 1.0
 * @desc 微信支付配置
 * @date 2019年08月30日 15:57
 */
@Data
@ToString
@FieldAlias(alias = "wxpay")
public class WXPayConfig {

    private WXPayConfig() {
    }

    private static WXPayConfig wxPayConfig = null;

    private static final String WXPAY_PREFIX = "wxpay";

    /**
     * 众号appid
     */
    @FieldAlias(alias = "appId",must = true)
    private String appId;

    /**
     * 商户id
     */
    @FieldAlias(alias = "mchId",must = true)
    private String mchId;

    /**
     * 付api安全密钥
     */
    @FieldAlias(alias = "mchKey",must = true)
    private String mchKey;

    /**
     * 支付类型
     */
    @FieldAlias(alias = "tradeType",must = true)
    private String tradeType;

    /**
     * 支付回调
     */
    @FieldAlias(alias = "payNotify",must = true)
    private String payNotify;

    /**
     * 退款回调
     */
    @FieldAlias(alias = "payNotify",must = false)
    private String refundNotify;

    /**
     * 证书地址
     */
    @FieldAlias(alias = "payNotify",must = true)
    private String certName;


}