package com.ocean.springcloud.oceanstream.stream.collector;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author: chao
 * @description:
 * @create: 2020-03-14 15:20
 */
public class CollectorPartitionBy {
    public static void main(String[] args) {
        Map<Boolean, List<Employee>> partionedByMaleGender =
                Employee.persons()
                        .stream()
                        .collect(Collectors.partitioningBy(Employee::isMale));
        System.out.println(partionedByMaleGender);

        System.out.println("-----------------------");

        List<String> initialData = CollectorsJoins.getInitialData();
        Map<Boolean, List<String>> tomcat = initialData.stream().collect(Collectors.partitioningBy(Predicate.isEqual("Tomcat")));
        tomcat.forEach((key,value) ->System.out.println("key:"+key+",value:"+value.toString()));
        System.out.println("-----------------------");


        Map<Boolean, Long> tomcat1 = initialData.stream().collect(Collectors.partitioningBy(Predicate.isEqual("Tomcat"), Collectors.counting()));
        tomcat1.forEach((key,value) ->System.out.println("key:"+key+",value:"+value.toString()));
    }


}
