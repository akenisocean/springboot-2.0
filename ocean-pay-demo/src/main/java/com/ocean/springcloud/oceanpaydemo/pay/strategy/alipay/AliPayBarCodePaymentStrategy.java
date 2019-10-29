package com.ocean.springcloud.oceanpaydemo.pay.strategy.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import com.ocean.springcloud.oceanpaydemo.pay.config.AliPayConfig;
import com.ocean.springcloud.oceanpaydemo.pay.dto.ali.AliPayBarCodePaymentDTO;
import com.ocean.springcloud.oceanpaydemo.pay.strategy.AbstractAliPayStrategy;
import com.ocean.springcloud.oceanpaydemo.pay.utils.JsonUtils;
import com.ocean.springcloud.oceanpaydemo.pay.vos.AliPayBarCodePaymentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chao
 * @version 1.0
 * @desc 支付宝扫码支付策略
 * @date 2019年09月11日 18:33
 */
@Slf4j
@Component(value = "aliPayBarCodePaymentStrategy")
public class AliPayBarCodePaymentStrategy extends AbstractAliPayStrategy<AliPayBarCodePaymentVO, AliPayBarCodePaymentDTO> {
    @Autowired
    private AliPayConfig aliPayConfig;

    @Override
    public AliPayBarCodePaymentVO operate(AliPayBarCodePaymentDTO aliPayBarCodePaymentDTO) {
        AlipayClient alipayClient = aliPayConfig.getAlipayClient();
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        request.setBizContent(JsonUtils.jsonFormat(aliPayBarCodePaymentDTO));
        AlipayTradePayResponse tradePayResponse = null;
        log.info(JSON.toJSONString(request));
        try {
            tradePayResponse = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        log.info(JSON.toJSONString(tradePayResponse));

        String code = tradePayResponse.getCode();
        //Code校验
        if(code.equals("10000")){
            System.out.println("支付宝付款码成功");
        }else if (code.equals("10003")){
            System.out.println("调用订单查询操作");
        }else if (code.equals("20000")){
            System.out.println("同步并返回撤销操作");
        }else if (code.equals("40004")){
            System.out.println("支付失败，请自己重试");
        }
        String body = tradePayResponse.getBody();
        //TODO 返回参数进行校验操作
        log.info("条码支付返回结果:{}",body);
        return new AliPayBarCodePaymentVO();

    }
}
