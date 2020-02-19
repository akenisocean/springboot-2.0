package com.ocean.springclouid.druidmybatismultiple;

import com.sun.org.apache.regexp.internal.RE;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author: chao
 * @description: 测试本地时间
 * @create: 2019-12-01 14:34
 */
public class TestLocalDateTime {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String plusTime = LocalDateTime.now().plusMinutes(20L).format(formatter);
//        System.out.printf(plusTime);


        long sysTime = 1575216000044L;
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(sysTime), ZoneId.systemDefault()).plusMinutes(19L);
        System.out.printf("------");
        System.out.println(localDateTime.format(formatter));
        if (localDateTime.isBefore(LocalDateTime.now())) {
            System.out.println("laji");
            return;
        }

    }
}
