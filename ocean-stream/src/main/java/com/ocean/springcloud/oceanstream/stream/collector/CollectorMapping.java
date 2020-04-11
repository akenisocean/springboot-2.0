package com.ocean.springcloud.oceanstream.stream.collector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: chao
 * @description: mapping类型转换并形成新的集合
 * @create: 2020-03-14 13:27
 */
public class CollectorMapping {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("123","456","789","1101","212121121","asdaa","3e3e3e","2321eew");
        List<Integer> collect = list.stream().limit(5).collect(Collectors.mapping(Integer::valueOf, Collectors.toList()));
        System.out.println(collect);

        System.out.println("--------------");
        List<String> names = Employee.persons().stream().collect(Collectors.mapping(Employee::getName, Collectors.toList()));
        names.forEach(System.out::println);
        // mapping+joining方法
        String names2 = Employee.persons().stream().collect(Collectors.mapping(Employee::getName, Collectors.joining(",")));
        System.out.println(names2);


    }

}
