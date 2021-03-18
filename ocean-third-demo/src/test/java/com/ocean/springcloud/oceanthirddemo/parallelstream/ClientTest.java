package com.ocean.springcloud.oceanthirddemo.parallelstream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author chao
 * @description
 * @create 2021-01-18 23:34
 */
public class ClientTest {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("PK",23));
        list.add(new Student("KK",26));
        list.add(new Student("MK",23));
        list.add(new Student("SK",21));
        list.add(new Student("RK",20));
        list.add(new Student("BK",30));

        Stream<Student> parallelStream = list.parallelStream();
        System.out.println("Student data send for processing...");
        parallelStream.forEach(s-> doProcess(s));
        
    }

    private static void doProcess(Student s) {
        System.out.println(s);
    }
}
