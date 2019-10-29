package com.ocean.springcloud.oceanpaydemo.pay.dto.wx;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author chao
 * @version 1.0
 * @desc Wechat base common data source transfer
 * @date 2019年09月12日 13:11
 */
@Data
public class WxpayBaseDTO {

    /**公众账号ID*/
    @XStreamAlias("appid")
    private String appId;

    /**商户号*/
    @XStreamAlias("mch_id")
    private String mchId;

    /**随机字符串*/
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**签名*/
    @XStreamAlias("sign")
    private String sign;

}
