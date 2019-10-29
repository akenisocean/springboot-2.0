package com.ocean.springcloud.oceanpaydemo.pay.dto.ali;

import com.ocean.springcloud.oceanpaydemo.pay.dto.wx.WxpayBaseDTO;
import lombok.Data;

/**
 * @author chao
 * @version 1.0
 * @desc 支付宝付款码支付传输层
 * @date 2019年09月11日 18:30
 */
@Data
public class AliPayBarCodePaymentDTO extends WxpayBaseDTO {

    /**商户订单号，需要保证不重复*/
    private String outTradeNo;

    /**条码支付固定传入 bar_code*/
    private String scene = "bar_code";

    /**用户付款码，，25-30 开头的长度为 16-24 位的数字，实际字符串长度以开发者获取的付款码长度为准；付款码使用一次即失效*/
    private String authCode;

    /**订单标题*/
    private String subject;

    /**商户门店编号*/
    private String storeId;
    /**支付总金额*/
    private String totalAmount;

    /**交易超时时间*/
    private String timeoutExpress;

}
