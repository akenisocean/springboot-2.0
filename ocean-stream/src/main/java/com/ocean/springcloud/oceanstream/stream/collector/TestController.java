package com.ocean.springcloud.oceanstream.stream.collector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author chao
 * @description
 * @create 2021-06-08 12:00
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("/test1")
    public Map<Month, String> test1() {
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
        return dobCalendar;
    }
}
