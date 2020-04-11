package com.ocean.springcloud.oceanstream.stream.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: chao
 * @description: Collectors.join方法
 * @create: 2020-03-14 10:55
 */
public class CollectorsJoins {
    public static void main(String[] args) {
        List<String> servers = getInitialData();
        String collect = servers.stream().collect(Collectors.joining(",","haha===","===shabi"));
        System.out.println(collect);
        String collect1 = servers.stream().collect(Collectors.joining("="));
        System.out.println(collect1);

    }

    public static List<String> getInitialData(){
        List<String> servers = new ArrayList<>();
        servers.add("Felordcn");
        servers.add("Tomcat");
        servers.add("Jetty");
        servers.add("Undertow");
        servers.add("Resin");
        return servers;
    }
}
