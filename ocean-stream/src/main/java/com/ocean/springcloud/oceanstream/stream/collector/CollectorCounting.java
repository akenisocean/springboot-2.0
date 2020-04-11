package com.ocean.springcloud.oceanstream.stream.collector;

import java.util.stream.Collectors;

/**
 * @author: chao
 * @description: 统计
 * @create: 2020-03-14 13:46
 */
public class CollectorCounting {
    public static void main(String[] args) {
        Long collect = Employee.persons().stream().collect(Collectors.counting());
        System.out.println(collect);
    }
}
