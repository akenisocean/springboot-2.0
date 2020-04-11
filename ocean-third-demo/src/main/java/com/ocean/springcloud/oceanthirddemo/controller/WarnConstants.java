package com.ocean.springcloud.oceanthirddemo.controller;

/**
 * @author: chao
 * @description: 告警常量
 * @create: 2020-01-13 17:21
 */
public interface WarnConstants {
    interface ProxyPortConstants{
        String defaultProxyIp = "172.31.6.6";
        int defaultProxyPort = 8080;
    }

    /**
     * 短信发送常量
     */
    interface smsConstants{
        // 短信应用 SDK AppID
        int appid = 1400306917; // SDK AppID 以1400开头
        // 短信应用 SDK AppKey
        String appkey = "ffcc1899a6081d1e7b18556665331ddc";
        // 需要发送短信的手机号码
        String[] phoneNumbers = {"21212313123", "12345678902", "12345678903"};
        // 短信模板 ID，需要在短信应用中申请
        int templateId = 521965; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请
        // 签名
        String smsSign = "万翼统一监控平台"; // NOTE: 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请
    }
    /**
     * 告警资源名称常量
     */
    interface WarnResouce{
        String resourceName = "资源监控";
    }
}
