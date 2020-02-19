package com.ocean.springcloud.oceanpaydemo.pay.test;

import com.ocean.springcloud.oceanpaydemo.pay.content.PayContent;
import com.ocean.springcloud.oceanpaydemo.pay.dto.ali.AliPayBarCodePaymentDTO;
import com.ocean.springcloud.oceanpaydemo.pay.dto.ali.AliPayBarCodeQueryDTO;
import com.ocean.springcloud.oceanpaydemo.pay.strategy.PayStrategy;
import com.ocean.springcloud.oceanpaydemo.pay.vos.AliPayBarCodePaymentVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author chao
 * @version 1.0
 * @desc 阿里支付测试controller
 * @date 2019年09月12日 9:27
 */
@RestController
@RequestMapping("/alipay")
public class AlipayTetstController {

    @Resource(name = "aliPayBarCodePaymentStrategy")
    private PayStrategy payStrategy;

    @GetMapping("/barCodePayment/{authCode}")
    public void barCodePayment(@PathVariable("authCode") String authCode) {
        AliPayBarCodePaymentDTO ali = new AliPayBarCodePaymentDTO();
        ali.setOutTradeNo(UUID.randomUUID().toString());
        ali.setAuthCode(authCode);
        ali.setSubject("车站买票");
        ali.setStoreId("dachaoSystem");
        ali.setTotalAmount("0.01");
        ali.setTimeoutExpress("2m");
        PayContent<AliPayBarCodePaymentVO, AliPayBarCodePaymentDTO> payContent = new PayContent(payStrategy);
        AliPayBarCodePaymentVO execute = payContent.execute(ali);
    }


    @Resource(name = "aliPayBarCodeQueryStrategy")
    private PayStrategy payStrategy2;

    @GetMapping("/barCodePaymentQuery/{authCode}")
    public void barCodePayment2(@PathVariable("authCode") String authCode) {
        AliPayBarCodeQueryDTO dto = new AliPayBarCodeQueryDTO();
        dto.setOutTradeNo(authCode);
        PayContent<AliPayBarCodePaymentVO, AliPayBarCodeQueryDTO> payContent = new PayContent(payStrategy2);
        AliPayBarCodePaymentVO execute = payContent.execute(dto);
    }


}
