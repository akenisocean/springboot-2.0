package com.ocean.springcloud.oceanfeignprovider.feign;

import com.ocean.springcloud.oceanfeignprovider.FeignProviderController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: chao
 * @description:
 * @create: 2020-03-03 17:26
 */
@Component
@Slf4j
public class FeignProviderFallback implements FeignProviderController {
    @Override
    public Map<String, String> test1() {
        log.info("当前时间{}",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()).toString());
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("fallback","fallback");
        returnMap.put("test1","test1");
        return returnMap;

    }
}
