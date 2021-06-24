package com.ocean.springcloud.oceanstream.commonio;

import lombok.SneakyThrows;

import java.net.URL;
import java.net.URLDecoder;

/**
 * @author chao
 * @description
 * @create 2021-06-08 16:47
 */


public class CommonIoTests {
    @SneakyThrows
    public static void main(String[] args) {
        String classPath = "http://192.168.3.201:5000/download/code_engines/java/143/2985/Sid_2985_f0a72ef72985defd29854ecf2985903129852155508b8611.class";
        URL url = new URL(classPath);
        String path = URLDecoder.decode(
                classPath.substring(classPath.lastIndexOf("/") + 1).split("\\.")[0], "utf-8");


    }
}
