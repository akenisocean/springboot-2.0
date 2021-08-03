package com.ocean.springcloud.oceanstream.function.predicate;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author chao
 * @description
 * @create 2021-08-03 13:04
 */
@Slf4j
public class Java8PredicateTest {


    public static List<Apple> prepareLoadData() {
        return Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );
    }

    public static void main(String[] args) {
        List<Apple> apples = prepareLoadData();
        List<Apple> greenApples = filterApples(apples, Java8PredicateTest::isGreenApple);
        log.info("绿色的苹果有:{}",greenApples.toString());

        List<Apple> heavyApples = filterApples(apples,Java8PredicateTest::isHeavyApple);
        log.info("大于150重量的苹果有:{}", heavyApples);
        // 思考一下，如果当前既要过滤出green颜色的苹果也要过滤重量大于150的苹果，如何实现呢？
        Predicate<Apple> greenPredicate = apple -> isGreenApple(apple);
        Predicate<Apple> heavyPredicate = apple -> isHeavyApple(apple);
        List<Apple> greenAndHeavyApples = filterApples(apples, greenPredicate.and(heavyPredicate));
        log.info("大于150重量以及绿色的苹果有:{}", greenAndHeavyApples);

        List<Apple> greenOrHeavyApples = filterApples(apples, greenPredicate.or(heavyPredicate));
        log.info("大于150重量或者绿色的苹果有:{}", greenOrHeavyApples);

    }


    /**
     * 谓词断言接入不同的过滤条件
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
    public static class Apple {

        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color='%s', weight=%d}", color, weight);
        }

    }
}
