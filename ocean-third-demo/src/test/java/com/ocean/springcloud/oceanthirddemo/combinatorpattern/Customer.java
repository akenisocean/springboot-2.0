package com.ocean.springcloud.oceanthirddemo.combinatorpattern;

import lombok.*;

import java.time.LocalDate;

/**
 * @author chao
 * @description
 * @create 2020-12-24 13:10
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Customer {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate dob;

}
