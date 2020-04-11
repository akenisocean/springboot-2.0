package com.ocean.springcloud.oceanstream.stream.collector;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author: chao
 * @description: 集合分组功能
 * @create: 2020-03-14 11:07
 */
public class CollectorsGroupBy {
    public static void main(String[] args) {
        List<String> servers = CollectorsJoins.getInitialData();
        // 只需一个分组参数classifier，内部自动将结果保存到一个map中，每个map的键为?类型（即classifier的结果类型），值为一个list，这个list中保存在属于这个组的元素。
        Map<Integer, List<String>> groupby1 = servers.stream().collect(Collectors.groupingBy(String::length));
        groupby1.forEach((key,value) -> System.out.println("key:"+key+",value:"+value.toString()));
        System.out.println("---------------------");
        //在上面方法的基础上增加了对流中元素的处理方式的Collector，比如上面的默认的处理方法就是Collectors.toList()
        Map<Integer, Set<String>> groupby2 = servers.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        groupby2.forEach((key,value)->  System.out.println("key:"+key+",value:"+value.toString()));
        System.out.println("---------------------");
        //在第二个方法的基础上再添加了结果Map的生成方法。
        Supplier<Map<Integer, Set<String>>> mapSupplier = () -> Collections.synchronizedMap(new HashMap<>());
        Map<Integer, Set<String>> groupby3 = servers.stream().collect(Collectors.groupingBy(String::length, mapSupplier, Collectors.toSet()));
        groupby3.forEach((key,value)->  System.out.println("key:"+key+",value:"+value.toString()));
        //concurrent
        Map<Gender, String>  namesByGender = Employee.persons()
                .stream()
                .collect(Collectors.groupingByConcurrent(Employee::getGender,
                        Collectors.mapping(Employee::getName, Collectors.joining(", "))));
        System.out.println(namesByGender);

    }
}
