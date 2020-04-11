package com.ocean.springcloud.oceanstream.stream.collector;

import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author: chao
 * @description: 先执行了一个归纳操作，然后再对归纳的结果进行 Function 函数处理输出一个新的结果。
 * @create: 2020-03-14 13:51
 */
public class CollectorCollectingAndThen {
    public static void main(String[] args) {
        List<String> initialData = CollectorsJoins.getInitialData();
        //所有名字加逗号后再全部转成大写
        String collect = initialData.stream().collect(Collectors.collectingAndThen(Collectors.joining(","), String::toUpperCase));
        System.out.println(collect);
        System.out.println("------------------------");

        Map<Month, String> dobCalendar = Employee
                .persons()
                .stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.groupingBy(
                                        p -> p.getDob().getMonth(),
                                        Collectors.mapping(Employee::getName,
                                                Collectors.joining(" "))), result -> {
                                    for (Month m : Month.values()) {
                                        result.putIfAbsent(m, "None");
                                    }
                                    return Collections.unmodifiableMap(new TreeMap<>(result));
                                }));

        dobCalendar.entrySet().forEach(System.out::println);
    }
}
