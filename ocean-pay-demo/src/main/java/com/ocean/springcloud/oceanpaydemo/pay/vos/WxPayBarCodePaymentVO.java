package com.ocean.springcloud.oceanpaydemo.pay.vos;

import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chao
 * @version 1.0
 * @desc Wechat BarCodePayment vo
 * @date 2019年09月11日 18:35
 */
@XStreamAlias("xml")
@Data
public class WxPayBarCodePaymentVO extends BaseWxPayResult implements Serializable {


    /**
     * 用户标识
     */
//    @XStreamAlias("openid")
//    private String openid;
//
//    /**
//     * 是否关注公众账号 取值范围：Y或N;Y-关注;N-未关注
//     */
//    @XStreamAlias("is_subscribe")
//    private String isSubscribe;
//
//    /**
//     * 交易类型 返回参数： MICROPAY 付款码支付
//     */
//    @XStreamAlias("trade_type")
//    private String tradeType;
//
//    /**
//     * 付款银行
//     */
//    @XStreamAlias("bank_type")
//    private String bankType;
//
//    /**
//     * 货币类型
//     */
//    @XStreamAlias("fee_type")
//    private String feeType;
//
//    /**
//     * 订单金额
//     */
//    @XStreamAlias("total_fee")
//    private String totalFee;
//
//
//    /**
//     * 现金支付金额
//     */
//    @XStreamAlias("cash_fee")
//    private String cashFee;
//
//    /**
//     * 微信支付订单号
//     */
//    @XStreamAlias("transaction_id")
//    private String transactionId;
//
//    /**
//     * 商户订单号
//     */
//    @XStreamAlias("out_trade_no")
//    private String outTradeNo;
//
//    @XStreamAlias("time_end")
//    private String timeEnd;




}
