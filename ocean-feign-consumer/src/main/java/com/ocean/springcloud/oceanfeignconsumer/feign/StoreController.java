package com.ocean.springcloud.oceanfeignconsumer.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 季超
 * @create 2018-12-21 12:30
 * @desc
 **/
@RestController
public class StoreController {

    @Autowired(required = false)
    private StoreClient storeClient;

    @Autowired
    private StoreClient2 storeClient2;


    @GetMapping("/stores")
    public List<Store> getStores() {
        List<Store> stores = storeClient.getStores();
        return stores;
    }

    @GetMapping("/stores2")
    public List<Store> getStores2() {
        List<Store> stores2 = storeClient2.getStores();
        return stores2;
    }
}
