package com.ocean.springcloud.oceangateway;

import java.math.BigDecimal;

/**
 * @author 季超
 * @create 2018-12-21 12:11
 * @desc
 **/

public class TestController {

    public static void main(String[] args) {
//        Date date = new Date(1545362726565L);
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);
        // -----------------------------------------------------------------/

        BigDecimal b3 = new BigDecimal("23.42");
        Integer integer = new Integer(3);
        BigDecimal multiply = b3.multiply(BigDecimal.valueOf(integer.longValue()));
        System.out.println(multiply.toString());

    }
}
