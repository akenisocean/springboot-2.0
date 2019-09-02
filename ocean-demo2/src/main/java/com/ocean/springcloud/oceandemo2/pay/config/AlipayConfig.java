package com.ocean.springcloud.oceandemo2.pay.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author chao
 * @version 1.0
 * @desc 支付宝配置
 * @date 2019年08月30日 15:54
 */
@FieldAlias(alias = "alipay",must = true)
@Data
@ToString
@Component
@ConditionalOnProperty(name = "alipay.haha")
public class AlipayConfig {
    public AlipayConfig() {
        System.out.println("-------------------------AlipayConfig--------------------------");
    }

    private static AlipayConfig alipayConfig = null;

    private static final String ALIPAY_PREFIX = "alipay";

    /**
     * 应用ID,您的APPID 收款账号既是您的APPID对应支付宝账号
     */
    @FieldAlias(alias = "appId",must = true)
    private String appId;

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    @FieldAlias(alias = "privateKey",must = true)
    private String privateKey;

    /**
     * 支付宝公钥 https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    @FieldAlias(alias = "publicKey",must = true)
    private String publicKey;

    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    @FieldAlias(alias = "notifyUrl",must = true)
    private  String notifyUrl;

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    @FieldAlias(alias = "returnUrl")
    private  String returnUrl;

    /**
     * 签名方式
     */
    @FieldAlias(alias = "signType",must = true)
    private  String signType;

    /**
     * 字符编码格式
     */
    @FieldAlias(alias = "charset",must = true)
    private  String charset;

    /**
     * 支付宝网关
     */
    @FieldAlias(alias = "gatewayUrl",must = true)
    private String gatewayUrl;

    /**
     * 日志存放
     */
    @FieldAlias(alias = "gatewayUrl")
    private String logPath;




    /**
     * 获取AlipayClient对象
     * @return
     */
//    public static AlipayClient getAlipayClient() {
//
//        AlipayConfig alipayConfig = getInstance();
//
//        AlipayClient alipayClient =
//                new DefaultAlipayClient(alipayConfig.getGatewayUrl(), alipayConfig.getAppId(), alipayConfig.getPrivateKey(),
//                        "JSON", alipayConfig.getCharset(), alipayConfig.getPublicKey(), alipayConfig.getSignType());
//
//        return alipayClient;
//
//    }
}
