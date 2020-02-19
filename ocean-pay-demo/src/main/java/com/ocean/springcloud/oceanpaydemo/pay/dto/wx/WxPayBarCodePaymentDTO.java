package com.ocean.springcloud.oceanpaydemo.pay.dto.wx;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author chao
 * @version 1.0
 * @desc Wechat face to face pay data source transfer
 * @date 2019年09月12日 13:09
 */
@XStreamAlias("xml")
@Data
public class WxPayBarCodePaymentDTO extends WxpayBaseDTO {

    /**
     * 商品描述
     */
    @XStreamAlias("body")
    private String body;

    /**
     * 商户订单号
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 订单金额
     */
    @XStreamAlias("total_fee")
    private String totalFee;

    /**
     * 终端IP
     */
    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;

    /**
     * 扫码支付授权码，设备读取用户微信中的条码或者二维码信息
     * （注：用户付款码条形码规则：18位纯数字，以10、11、12、13、14、15开头）
     */
    @XStreamAlias("auth_code")
    private String authCode;
}
