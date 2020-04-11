package com.ocean.springcloud.oceanstream.stream.optinal;

import com.ocean.springcloud.oceanstream.stream.collector.Employee;
import com.ocean.springcloud.oceanstream.stream.collector.Gender;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

/**
 * @author: chao
 * @description:
 * @create: 2020-03-14 16:04
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> o = Optional.ofNullable("abc");
        o.ifPresent(a -> System.out.println("asdad"+a));
        System.out.println(o.isPresent());

        String s = o.orElseThrow(() -> new IllegalArgumentException("laji"));
        System.out.println(s);

        Employee ken = new Employee(1, null, Gender.MALE, LocalDate.of(1970,
                Month.MAY, 4), 6123.0);


        System.out.println(Optional.of(new UserOpt())
                .map(UserOpt::getUserAddress)
                .map(UserAddress::getUserCountry)
                .map(UserCountry::getCountry)
                .orElse("-------lajimap"));

        System.out.println(Optional.ofNullable(new UserOpt())
                .flatMap(a -> Optional.ofNullable(a.getUserAddress()).filter(gg ->gg.equals("aa")))
                .flatMap(b -> Optional.ofNullable(b.getUserCountry()))
                .flatMap(c -> Optional.ofNullable(c.getCountry()))
                .orElse("------laji------"));


        Integer count = 0;
        Integer integer = Optional.of(count).filter(b -> !b.equals(0)).orElse(9876);
        System.out.println("----------");
        System.out.println(integer.toString());

        UserCountry userCountry = new UserCountry();
        userCountry.setCountry("la");
        userCountry.setCountryName("la2");
        Optional.ofNullable(userCountry).filter(u -> StringUtils.isNotBlank(u.getCountry()))
                .filter(u -> StringUtils.isNotBlank(u.getCountryName()))
                .map(u -> u.getId()).orElseThrow(() -> new RuntimeException("UserCountry中属性不能为空"));




    }
}
