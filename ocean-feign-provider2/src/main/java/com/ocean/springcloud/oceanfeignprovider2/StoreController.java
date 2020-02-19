package com.ocean.springcloud.oceanfeignprovider2;

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
public class StoreController {


    @GetMapping("/stores")
    public List<Store> getStores() {
        List<Store> list = new ArrayList<>();
        list.add(new Store("1", "2", "3"));
        list.add(new Store("4", "2", "3"));
        list.add(new Store("5", "2", "3"));

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;

    }
}
