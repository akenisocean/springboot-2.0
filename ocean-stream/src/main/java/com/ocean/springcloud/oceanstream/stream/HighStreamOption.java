package com.ocean.springcloud.oceanstream.stream;

import com.ocean.springcloud.oceanstream.stream.optinal.UserCountry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: chao
 * @description: 高级stream流操作
 * @create: 2020-04-25 16:51
 */

public class HighStreamOption {
    public static void main(String[] args) {
       Map<String, List<UserCountry>> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            List<UserCountry> userCountries = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                UserCountry userCountry = new UserCountry();
                userCountry.setId(i+"");
                userCountry.setCountry("country"+i);
                userCountry.setCountryName("countyName"+i);
                userCountries.add(userCountry);
            }
            map.put(i+"",userCountries);
        }
        List<UserCountry> collect = map.entrySet().stream().map(Map.Entry::getValue).flatMap(List::stream).collect(Collectors.toList());
        System.out.println(collect.size());

    }
}
