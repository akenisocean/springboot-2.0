package com.ocean.springcloud.oceanpaydemo.pay.strategy.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.ocean.springcloud.oceanpaydemo.pay.dto.ali.AliPayBarCodeQueryDTO;
import com.ocean.springcloud.oceanpaydemo.pay.strategy.AbstractAliPayStrategy;
import com.ocean.springcloud.oceanpaydemo.pay.utils.JsonUtils;
import com.ocean.springcloud.oceanpaydemo.pay.vos.AliPayBarCodePaymentVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

/**
 * @author chao
 * @version 1.0
 * @desc 支付宝扫码支付策略
 * @date 2019年09月11日 18:33
 */
@Slf4j
@Component(value = "aliPayBarCodeQueryStrategy")
public class AliPayBarCodeQueryStrategy extends AbstractAliPayStrategy<AliPayBarCodePaymentVO, AliPayBarCodeQueryDTO> {

    @Override
    public AliPayBarCodePaymentVO operate(AliPayBarCodeQueryDTO queryDTO) {
        AlipayClient alipayClient = super.getAliPayConfig().getAlipayClient();
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent(JsonUtils.jsonFormat(queryDTO));
        AlipayTradeQueryResponse tradeQueryResponse;
        try {
            tradeQueryResponse = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            log.error("支付宝条码支付出错：{}", ExceptionUtils.getFullStackTrace(e));
            throw new RuntimeException("支付错误");
        }
        if (null == tradeQueryResponse) {
            throw new RuntimeException("支付错误");
        }
        String body = tradeQueryResponse.getBody();
        System.out.println(body);

        return null;
    }


}
