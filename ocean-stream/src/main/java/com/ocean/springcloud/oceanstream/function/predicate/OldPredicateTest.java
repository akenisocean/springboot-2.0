package com.ocean.springcloud.oceanstream.function.predicate;

import com.ocean.springcloud.oceanstream.function.Apple;
import lombok.extern.slf4j.Slf4j;
import sun.jvm.hotspot.jdi.CharValueImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chao
 * @description
 * @create 2021-08-03 13:04
 */
@Slf4j
public class OldPredicateTest {


    public static List<Apple> prepareLoadData() {
        return Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );
    }

    public static void main(String[] args) {
        List<Apple> apples = prepareLoadData();
        List<Apple> greenApples = filterGreenApples(apples);
        log.info("绿色的苹果有:{}",greenApples.toString());

        List<Apple> heavyApples = filterHeavyApples(apples);
        log.info("大于150重量的苹果有:{}", heavyApples);
        // 思考一下，如果当前既要过滤出green颜色的苹果也要过滤重量大于150的苹果，如何实现呢？

    }


    /**
     * 过滤库存，green颜色的苹果进行过滤
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * 过滤库存，重量大于150的进行过滤
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }
}
