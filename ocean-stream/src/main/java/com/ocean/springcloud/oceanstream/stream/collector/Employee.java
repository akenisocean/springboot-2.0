package com.ocean.springcloud.oceanstream.stream.collector;

import lombok.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * @author: chao
 * @description: 雇员表
 * @create: 2020-03-14 10:42
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;


    public boolean isMale() {
        return this.gender == Gender.MALE;
    }

    public static List<Employee> persons() {
        Employee ken = new Employee(1, "Jame", Gender.MALE, LocalDate.of(1970,
                Month.MAY, 4), 6123.0);
        Employee jeff = new Employee(2, "Jeff", Gender.MALE, LocalDate.of(1971,
                Month.JULY, 5), 7112.0);
        Employee donna = new Employee(3, "Jane", Gender.FEMALE, LocalDate.of(1972,
                Month.JULY, 9), 8712.0);
        Employee chris = new Employee(4, "Jodd", Gender.MALE, LocalDate.of(1973,
                Month.DECEMBER, 6), 1823.0);
        Employee laynie = new Employee(5, "Janey", Gender.FEMALE, LocalDate.of(
                1974, Month.DECEMBER, 3), 1234.0);
        Employee lee = new Employee(6, "Jason", Gender.MALE, LocalDate.of(1975,
                Month.MAY, 8), 2412.0);

        // Create a list of persons
        List<Employee> persons = Arrays
                .asList(ken, jeff, donna, chris, laynie, lee);

        return persons;
    }
}
