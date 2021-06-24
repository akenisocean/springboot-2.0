package com.ocean.springcloud.oceanstream.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author chao
 * @description
 * @create 2021-04-14 23:49
 */
public class Java8BiFunction1 {
    public static void main(String[] args) {
        //两个对象进行相加操作
        BiFunction<Integer,Integer,Integer> func = (x1,x2)-> x1 + x2;
        System.out.println(func.apply(10, 20));//30

        //两个x1的y的幂次方的值
        BiFunction<Integer,Integer,Double> func2 = (x1,x2) -> Math.pow(x1,x2);
        System.out.println(func2.apply(2,3));//8

        // 两个Integer返回一个List集合
        BiFunction<Integer,Integer, List<Integer>> func3 = (x1, x2) -> Arrays.asList(x1+x2);
        System.out.println(func3.apply(3, 4));



        /** BiFuntion + Function */
        BiFunction<Integer, Integer, Double> func4 = (a1, a2) -> Math.pow(a1, a2);
        Function<Double, String> func5 = (input) -> "Result : " + input;

        String apply = func4.andThen(func5).apply(3, 4);
        System.out.println(apply);


    }
}
