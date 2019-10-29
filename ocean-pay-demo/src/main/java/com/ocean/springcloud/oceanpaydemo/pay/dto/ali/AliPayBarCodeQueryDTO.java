package com.ocean.springcloud.oceanpaydemo.pay.dto.ali;

import lombok.Data;

/**
 * @author chao
 * @version 1.0
 * @desc 条码支付查询接口
 * @date 2019年09月20日 13:07
 */
@Data
public class AliPayBarCodeQueryDTO {
    private String outTradeNo;
    private String tradeNo;

}
