package com.ocean.springcloud.oceannetty;

import org.springframework.util.StringUtils;

/**
 * @author 季超
 * @create 2018-11-13 17:15
 * @desc
 **/
public class HelloTest {
    public static void main(String[] args) {
        String name = "AAa";
        String uncapitalize = StringUtils.uncapitalize(name);
        System.out.println(uncapitalize);

    }
}
