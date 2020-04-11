package com.ocean.springcloud.oceanstream.stream.collector;

import java.time.Month;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author: chao
 * @description: public static <T,A,R,RR> Collector<T,A,RR> collectingAndThen(Collector<T,A,R> downstream,      Function<R,RR> finisher)
 * @create: 2020-03-14 10:41
 */
public class StreamCollectors {
    public static void main(String[] args) {
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
