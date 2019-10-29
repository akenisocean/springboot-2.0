package com.ocean.springcloud.oceanpaydemo.pay.test;

import com.ocean.springcloud.oceanpaydemo.pay.content.PayContent;
import com.ocean.springcloud.oceanpaydemo.pay.dto.wx.WxPayBarCodePaymentDTO;
import com.ocean.springcloud.oceanpaydemo.pay.strategy.PayStrategy;
import com.ocean.springcloud.oceanpaydemo.pay.utils.RandomUtil;
import com.ocean.springcloud.oceanpaydemo.pay.vos.WxPayBarCodePaymentVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * @author chao
 * @version 1.0
 * @desc 阿里支付测试controller
 * @date 2019年09月12日 9:27
 */
@RestController
@RequestMapping("/wx")
public class WxpayTetstController {

    @Resource(name = "wxPayBarCodePaymentStrategy")
    private PayStrategy payStrategy;
    @GetMapping("/barCodePayment/{authCode}")
    public void barCodePayment(@PathVariable("authCode")String authCode) throws UnknownHostException {
        WxPayBarCodePaymentDTO dto = new WxPayBarCodePaymentDTO();
        dto.setBody("朕爱出行测试操作");
        dto.setOutTradeNo(UUID.randomUUID().toString().replaceAll("-","").substring(0,32));
        dto.setTotalFee("0.01");
        dto.setSpbillCreateIp(InetAddress.getLocalHost().getHostAddress());
        dto.setAuthCode(authCode);
        dto.setNonceStr(RandomUtil.generateString(8));
        PayContent<WxPayBarCodePaymentVO, WxPayBarCodePaymentDTO> payContent = new PayContent(payStrategy);
        WxPayBarCodePaymentVO execute = payContent.execute(dto);
        System.out.println(execute);
    }



}
