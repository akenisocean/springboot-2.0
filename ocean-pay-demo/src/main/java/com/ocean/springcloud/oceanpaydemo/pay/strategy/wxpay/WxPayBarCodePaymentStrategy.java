package com.ocean.springcloud.oceanpaydemo.pay.strategy.wxpay;

import com.github.binarywang.wxpay.util.SignUtils;
import com.ocean.springcloud.oceanpaydemo.pay.config.ApiUrlConstants;
import com.ocean.springcloud.oceanpaydemo.pay.config.WxPayConfig;
import com.ocean.springcloud.oceanpaydemo.pay.dto.wx.WxPayBarCodePaymentDTO;
import com.ocean.springcloud.oceanpaydemo.pay.strategy.PayStrategy;
import com.ocean.springcloud.oceanpaydemo.pay.utils.HttpUtils;
import com.ocean.springcloud.oceanpaydemo.pay.utils.XmlUtils;
import com.ocean.springcloud.oceanpaydemo.pay.vos.WxPayBarCodePaymentVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author chao
 * @version 1.0
 * @desc 支付宝扫码支付策略
 * @date 2019年09月11日 18:33
 */
@Slf4j
@Component(value = "wxPayBarCodePaymentStrategy")
public class WxPayBarCodePaymentStrategy implements PayStrategy<WxPayBarCodePaymentVO, WxPayBarCodePaymentDTO> {
    @Autowired
    private WxPayConfig wxPayConfig;

    @Override
    public WxPayBarCodePaymentVO operate(WxPayBarCodePaymentDTO wxDTO) {
        wxDTO.setAppId(wxPayConfig.getWechatAppId());
        wxDTO.setMchId(wxPayConfig.getWechatMchId());
        wxDTO.setTotalFee(new BigDecimal(wxDTO.getTotalFee()).multiply(new BigDecimal("100")).intValue()+"");
        wxDTO.setNonceStr(wxDTO.getOutTradeNo());
        wxDTO.setSign(null);
        wxDTO.setSign(SignUtils.createSign(wxDTO,ApiUrlConstants.WxPayConstants.DEFAULT_SIGN_TYPE, wxPayConfig.getWechatKey(), new String[0]));

        String xml = XmlUtils.toXML(wxDTO);
        log.info("微信H5支付下单请求参数：{}", xml);
        String responseContent = null;
        try {
            responseContent = HttpUtils.doPost(ApiUrlConstants.WxPayConstants.BAT_CODE_PAYMENT_URL,xml);
            log.info("微信H5支付下单返回参数：{}", responseContent);
        } catch (Exception e) {
           log.error("微信当面支付错误，{}", ExceptionUtils.getFullStackTrace(e));
        }
        WxPayBarCodePaymentVO wxPayBarCodePaymentVO = WxPayBarCodePaymentVO.fromXML(responseContent, WxPayBarCodePaymentVO.class);
        return wxPayBarCodePaymentVO;
    }
}
