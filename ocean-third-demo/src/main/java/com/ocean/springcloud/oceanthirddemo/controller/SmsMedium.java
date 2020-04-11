package com.ocean.springcloud.oceanthirddemo.controller;

import com.alibaba.fastjson.JSON;
import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.httpclient.HTTPClient;
import com.github.qcloudsms.httpclient.HTTPException;
import com.github.qcloudsms.httpclient.ProxyHTTPClient;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author: chao
 * @description: 短信发送服务
 * @create: 2020-01-13 21:39
 */
@Service
@Slf4j
public class SmsMedium {


    /**
     * 多个用户发送短信
     * @param phoneNumbers  要发送的所有手机号
     * @param params  发送的参数集合，注意顺序
     */
    public boolean smsMuiltiSend(ArrayList<String> phoneNumbers, ArrayList<String> params){
        try {
            HTTPClient httpClient = new ProxyHTTPClient(WarnConstants.ProxyPortConstants.defaultProxyIp,WarnConstants.ProxyPortConstants.defaultProxyPort);
            SmsMultiSender msender = new SmsMultiSender(WarnConstants.smsConstants.appid, WarnConstants.smsConstants.appkey,httpClient);
            SmsMultiSenderResult result =  msender.sendWithParam("86", phoneNumbers,
                    WarnConstants.smsConstants.templateId, params, "", "", "");
            log.info("短信发送返回信息:{}",JSON.toJSONString(result));
          return true;
        } catch (HTTPException e) {
            // HTTP 响应码错误
            log.error("短信发送失败",e);
        } catch (JSONException e) {
            // JSON 解析错误
            log.error("短信JSON解析错误",e);
        } catch (IOException e) {
            // 网络 IO 错误
            log.error("网络 IO 错误",e);
        }catch (Exception e){
            log.error("短信发送未知异常",e);
        }
        return false;
    }
}
