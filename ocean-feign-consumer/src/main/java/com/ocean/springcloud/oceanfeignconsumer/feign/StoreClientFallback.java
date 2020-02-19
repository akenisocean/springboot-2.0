package com.ocean.springcloud.oceanfeignconsumer.feign;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 季超
 * @create 2018-12-21 16:36
 * @desc
 **/
@Component
public class StoreClientFallback implements StoreClient {

    @Override
    public List<Store> getStores() {
        List<Store> stores = new ArrayList<>();
        stores.add(new Store("error", "error", "error"));
        return stores;
    }

    @Override
    public Store update(Long storeId, Store store) {
        return null;
    }
}
