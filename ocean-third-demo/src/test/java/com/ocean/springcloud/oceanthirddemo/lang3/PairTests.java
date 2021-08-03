package com.ocean.springcloud.oceanthirddemo.lang3;

import org.apache.commons.lang3.tuple.Pair;

/**
 * @author chao
 * @description 一对使用样例        Best Java code snippets using org.apache.commons.lang3.tuple.Pair.of
 * @create 2021-07-15 11:14
 */
public class PairTests {

    public static void main(String[] args) {
        Pair<PairTests, String> jackchao = Pair.of(new PairTests(), "jackchao");
        System.out.println(jackchao.getLeft());
    }
}
