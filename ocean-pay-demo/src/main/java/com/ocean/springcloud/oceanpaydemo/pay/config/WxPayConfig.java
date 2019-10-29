package com.ocean.springcloud.oceanpaydemo.pay.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chao
 * @version 1.0
 * @desc 微信支付配置
 * @date 2019年09月11日 18:08
 */
@Component
@ConfigurationProperties(prefix = "wxpay")
@Data
public class WxPayConfig {
  private String wechatAppId;
  private String wechatMchId;
  private String wechatKey;
  private String wechatIp;
  private String wechatOpUserId;
  private String wechatCertPath;
  private String wechatCallback;
}
