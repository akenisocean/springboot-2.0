package com.ocean.springcloud.oceanmybaitsplus.rsa;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: chao
 * @description: rsa测试
 * @create: 2020-03-05 21:05
 */
@RestController
@RequestMapping("/rsa")
public class RsaTestController {


    @PostMapping("/rsaTest")
    public Map<String,String> rsaTest(@RequestParam("jsondata")String jsondata,@RequestParam("sign")String sign){
        Map<String, String> map = new HashMap<>(2);
        map.put("jsondata",jsondata);
        map.put("sign",sign);
        return map;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = RSAUtils.genKeyPair();
        map.forEach((key,value)->{System.out.println("key"+key+"-------"+"value"+value);});


    }
}
