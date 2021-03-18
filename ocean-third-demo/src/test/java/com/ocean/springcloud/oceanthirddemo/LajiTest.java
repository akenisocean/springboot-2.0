package com.ocean.springcloud.oceanthirddemo;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

/**
 * @author: chao
 * @description:
 * @create: 2020-02-24 12:59
 */
public class LajiTest {
    public static void main(String[] args) {
        long endTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).getEpochSecond();
        long startTime = LocalDateTime.now().minus(1, ChronoUnit.DAYS).toInstant(ZoneOffset.ofHours(8)).getEpochSecond();
        System.out.printf("开始时间:%s\n",endTime);
        System.out.printf("结束时间:%s\n",startTime);
        System.out.println((endTime - startTime) / 3600);

    }
}
