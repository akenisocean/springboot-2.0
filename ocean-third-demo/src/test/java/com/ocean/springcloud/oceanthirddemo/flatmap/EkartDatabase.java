package com.ocean.springcloud.oceanthirddemo.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chao
 * @description
 * @create 2021-01-18 22:42
 */
public class EkartDatabase {

    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("39798866", "87654488")),
                new Customer(102, "smith", "john@gmail.com", Arrays.asList("4353453453", "65645646456")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("87654433", "7654322")),
                new Customer(104, "kely", "kely@ .com", Arrays.asList("34423434", "231414131"))
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Customer> allCustomer = EkartDatabase.getAll();
        // 获取所有的邮箱
        List<String> emailCollectList = allCustomer.stream().map(Customer::getEmail).collect(Collectors.toList());
        // 获取所有的手机号码，map方式无法实现
        List<List<String>> collect = allCustomer.stream().map(Customer::getPhoneNumbers).collect(Collectors.toList());
        // flatmap方式获取手机好吗
        List<String> allPhoneNumberList = allCustomer.stream().flatMap(customer -> customer.getPhoneNumbers().stream()).collect(Collectors.toList());

    }
}
