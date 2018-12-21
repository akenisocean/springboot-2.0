package com.ocean.springcloud.oceanfeignprovider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 季超
 * @create 2018-12-21 12:30
 * @desc
 **/
@RestController
@Slf4j
public class StoreController {


    @GetMapping("/stores")
    public List<Store> getStores(){
        List<Store> list = new ArrayList<>();
        list.add(new Store("1","2","3"));
        list.add(new Store("2","2","3"));
        list.add(new Store("3","2","3"));
        log.info("ocean-feign-provider/stores开始执行了");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;

    }
}
