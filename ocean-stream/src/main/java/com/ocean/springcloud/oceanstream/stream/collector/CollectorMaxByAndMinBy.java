package com.ocean.springcloud.oceanstream.stream.collector;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: chao
 * @description:
 * @create: 2020-03-14 15:32
 */
public class CollectorMaxByAndMinBy {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("1","2","3");

        Optional<String> o =  s.collect(Collectors.maxBy(Comparator.reverseOrder()));

        if(o.isPresent()){
            System.out.println(o.get());
        }else{
            System.out.println("no value");
        }
        System.out.println("------------");

        List<String> list = Arrays.asList("123","456","789","1101","212121121","asdaa","3e3e3e","2321eew");
        System.out.println(list.stream().collect(Collectors.maxBy((a,b) -> a.length()-b.length())));
        System.out.println(list.stream().collect(Collectors.minBy((a,b) -> a.length()-b.length())));

    }
}
