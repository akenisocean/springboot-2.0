package com.ocean.springcloud.oceangateway;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 季超
 * @create 2018-12-21 12:11
 * @desc
 **/

public class TestController {

    public static void main(String[] args) {
        Date date = new Date(1545362726565L);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}
