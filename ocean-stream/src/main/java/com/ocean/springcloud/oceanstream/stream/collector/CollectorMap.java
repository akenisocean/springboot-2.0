package com.ocean.springcloud.oceanstream.stream.collector;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: chao
 * @description: map集合
 * @create: 2020-03-14 15:41
 */
public class CollectorMap {
    public static void main(String[] args) {
        //map中的三个参数方法作用
        /**
         * 解释： toMap()的第一个参数就是用来生成key值的，第二个参数就是用来生成value值的。第三个参数用在key值冲突的情况下：如果新元素产生的key在Map中已经出现过了，第三个参数就会定义解决的办法。
         * 第一个参数UserBo::getUserId 表示选择UserBo的getUserId作为map的key值；
         * 第二个参数v -> v表示选择将原来的对象作为map的value值；
         * 第三个参数(v1, v2) -> v1中，如果v1与v2的key值相同，选择v1作为那个key所对应的value值
         */
        Map<Gender,String> genderToNamesMap  =
                Employee.persons()
                        .stream()
                        .collect(Collectors.toMap(Employee::getGender,
                                Employee::getName,
                                (oldValue, newValue)  ->  String.join(", ", oldValue,  newValue)));
        System.out.println(genderToNamesMap);

        System.out.println("--------------");

    }
}
