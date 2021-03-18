package com.ocean.springcloud.oceanthirddemo.predicate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author chao
 * @description 断言操作
 * @create 2021-01-09 20:24
 */
public class PredicateAsParameter {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(8, 9, 7, 3, 2, 10, 7);

        printFilter(numList,x -> x>5);
        printFilter(numList,x -> true);
        printFilter(numList,x -> false);
    }
    public static void printFilter(List<Integer> nums, Predicate<Integer> condition){
        for (Integer num : nums) {
            if (condition.test(num)){
                System.out.println(num);
            }
        }
    }

    @Test
    public void test1(){
        // Creating predicate
        Predicate<Integer> lesserthan = i -> (i < 18);

        // Calling Predicate method
        System.out.println(lesserthan.test(10));
    }

    @Test
    public void test2(){
        Predicate<Integer> greaterThanTen = (i) -> i > 10;

        // Creating predicate
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);

        // Calling Predicate method
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);
    }

    @Test
    public void test3(){
        pred(10, (i) -> i > 7);
    }
    static void pred(int number, Predicate<Integer> predicate)
    {
        if (predicate.test(number)) {
            System.out.println("Number " + number);
        }
    }
}

