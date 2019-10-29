package com.ocean.springcloud.oceanpaydemo;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import com.ocean.springcloud.oceanpaydemo.pay.config.AliPayConfig;
import com.ocean.springcloud.oceanpaydemo.pay.dto.ali.AliPayBarCodePaymentDTO;
import com.ocean.springcloud.oceanpaydemo.pay.dto.ali.AliPayBarCodeQueryDTO;
import com.ocean.springcloud.oceanpaydemo.pay.strategy.alipay.AliPayBarCodeQueryStrategy;
import com.ocean.springcloud.oceanpaydemo.pay.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OceanPayDemoApplicationTests {



	@Autowired
	private AliPayConfig aliPayConfig;



	@Test
	public void alipayConfigTest(){
		System.out.println(aliPayConfig.getAlipayalipayId());
		AlipayClient alipayClient = aliPayConfig.getAlipayClient();
		System.out.println(alipayClient);
	}





















	private static final String APP_ID = "2018110662027445";
	private static final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCvSgOQG5uRQqMl8i2DW1bNFTwZbAO3SmFqo2J24Xw2zsXiHwtcV55EeTImGs/ztMW9jaZUS+J5kKSrUVRpgaWWW9hzjhg+AX6QTcN1rH13pdnlWjK0oaiQPfm2FdfkTLfOPmPT7PXJMmYI4EX/8GzGnSe5Nd8I500yB4XAbIElwY6p+JmNEXHQ5jdXu22Er/FP5gFhDSQQ0AajbNBIZgHw3eaCqxZmVdWn40yvyralnUy7eqJz5wihRh0sZavQQW/b1VyijEEBOY37/hVw/yktHIYJcG0+3OOtg8hdp855cP416fLGLkUOsNti2eH3PanvK8SoPmVjUIM0bh1R27prAgMBAAECggEAZvwtK7WMqMNl5x1p8Arx7HvVW3pClKV2pphneUDxIaJKUJe8rPwtWD18YTbPhndm1f8rAcuzu4hntt+JoJMzHivH99w8EfH+0fleJPy6mlkus7lSoR15U4WV+IzM0qzgMKQnMpO9s/+QQxbBCaXPwsECXaZw62I50HLq+irFldAtcLSDPS2tGyk8Kz0nfWQqI1mCjvZux63efcIcCjc5m0QXWA0QGeB03zoHbXSD5v3bwLiTBP7bbILoAGqEPxaMzAyJxY2iV2do9vv9XhyDeqfJHbXiycTqblbQtx2SVZbKyNhDpNsC1/KKw2ieAN6xWijojD8Mha9oUZUZsWAvAQKBgQD9rZyWiDlvFZYfOyxnY/LXxl/HBnnCUTQkks+bHvglJG34PWu71rrOFP2p17jilOUXC/PxAZH+fDRiRZu2DZ0DhkDxzFKFYbyYBGjBBfuTq+JyDloLMuVOZ4Q4Rl68qH49r1r9fF2GvMDw6JMPCWl3cwUwbgPZcomKFeTdwN1JcQKBgQCw5Lr7S5RWtkVaulzLjLBIxcN2dF2s+H2TzKJa5cAskOFrWBmx2gOAbAXgtOKj9XmWckbJt5J4b91PAvZlLmKaKopupwzyvy1jH0hjnb57BaV+zTEUqJyMXoKgpYZjHyEGNLupFlZNwHtcNb8TVNNHOR3/XpzjdWe5cfQ+TMrzmwKBgQDTwASSftl6SUmLfkhdcUe3J4axSk1+j2v4D3guIta9okANU6/HFsHN3iWzjTduIx1rdHXGuinUhHbxhOsqNwjWdU1myMglQGU9e4i5frX2GScnT6WH7Y8NOElc9BiGYBsogGRybUpgetSPA4QlrBSWObOeLmcWLo5ybj4hgKj2cQKBgCGV2/Z4XBq2kqZuOc4f0RyQB9OGtn5v04/rS2wMsRcFDveNi5tb9Ew+tkL6tQlCQyqQWeZUp0ecnZ0xx8xgKTJyH0RxDSFNsPVf7COVwKOk584ScV4lwUtZal3L758EOwXtny+0YQB0KjfQsI2gDlk4e/yPXyREl0P7Yc8uT14/AoGAJNqAZiFklecryqXgZZPvZ4em7FuQdlb2On5353wXNtIsZZuB6XjSN/hTIydOQE+Cie9YZjA1SDDWUH58iO7CcJleUkaFPxTkLPDzVrYBslNRoo4OF3/www8zy1aEmI6PWgt7ccLHpylgfypJML+zSGOcHVHTjXOFyGN3zp0umX0=";
	private static final String CHARSET = "UTF-8";
	private static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnU0zYEHWQSYrnOJYzQHp4LdLsG2bZ3mftDKCe45uU/h2HVXxu3ZtGTJpS9n/ptS1sQkyBFf4vKUErOrOAN9v3eappXICQR5/0//lm3h6INDM+P6zneDNPAKuHt/s8Z8pKGT5kTBNTulOPYu8ESwybV6ZXh/u1Yoi27yBRrOC+akeL40EiTBHF2FpmOFRV42aIb3TIgdgiMWpgDUO2YR+qA7sDEiodnwSoWrFbv7sJtIBj6gMUpsVQUiTt3zGLUGekdrawR4bFRxvE4T7yYQ0E744HURuICnbbFUQappeULIAfmofy6tiNgBez6ukXoenBaXDRsrSK2DD+F7rvbC+sQIDAQAB";

	@Test
	public void alipayTest() throws AlipayApiException {

		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
		AlipayTradePayRequest request = new AlipayTradePayRequest(); //创建API对应的request类
		AliPayBarCodePaymentDTO ali = new AliPayBarCodePaymentDTO();
		ali.setOutTradeNo(UUID.randomUUID().toString());
		ali.setAuthCode("282895529051016785");
		ali.setSubject("车站买票");
		ali.setStoreId("dachaoSystem");
		ali.setTotalAmount("0.01");
		ali.setTimeoutExpress("2m");
		request.setBizContent(JsonUtils.jsonFormat(ali)); //设置业务参数
		AlipayTradePayResponse response = alipayClient.execute(request); //通过alipayClient调用API，获得对应的response类
		System.out.print(response.getBody());
	}


	@Resource(name = "aliPayBarCodeQueryStrategy")
	private AliPayBarCodeQueryStrategy aliPayBarCodeQueryStrategy;
	@Test
	public void alipayQuery(){

		AliPayBarCodeQueryDTO dto = new AliPayBarCodeQueryDTO();
		dto.setOutTradeNo("UPY1909230001150");
		aliPayBarCodeQueryStrategy.operate(dto);
	}

}
