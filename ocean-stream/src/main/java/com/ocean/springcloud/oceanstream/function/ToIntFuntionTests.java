package com.ocean.springcloud.oceanstream.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

/**
 * @author chao
 * @description java8中的tointfunction函数使用使用
 * @create 2021-04-01 11:30
 */
public class ToIntFuntionTests {
    public static void main(String[] args) {
        //lambda 函数表达式
        ToIntFunction<Integer> lambdaObj = value -> value * 25;
        System.out.println("The result is: " + lambdaObj.applyAsInt(10));

        ToIntFunction<String> lenFn = String::length;   // using method reference
        System.out.println("The length of a String is: " + lenFn.applyAsInt("tutorialspoint"));

        /************examples 2 collection operation ************/

        // 集合操作
        List<String> list = new ArrayList<String>();
        list.add("11");
        list.add("22");
        list.add("33");
        list.add("44");
        list.add("55");
        //  lambda expression
        ToIntFunction<String> function = (String item) -> Integer.valueOf(item);
        list.stream().mapToInt(function).forEach(System.out::println);
        // 统计当前集合中的数量
        System.out.printf("当前集合中的数量总和为:%s",list.stream().mapToInt(function).sum());

    }
}
