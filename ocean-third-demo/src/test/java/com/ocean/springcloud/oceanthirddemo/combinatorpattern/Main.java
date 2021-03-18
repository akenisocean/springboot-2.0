package com.ocean.springcloud.oceanthirddemo.combinatorpattern;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author chao
 * @description
 * @create 2020-12-24 13:16
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Customer customer = new Customer("Alice", "alice@gmail.com","+08989898989", LocalDate.of(2020, 1, 1));

        CustomerValidatorService customerValidatorService = new CustomerValidatorService();
        System.out.println(customerValidatorService.isValid(customer));


        //if valid We can store customer in db


        //Using combinator pattern
        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAdult())
                .apply(customer);

        if (result != CustomerRegistrationValidator.ValidationResult.SUCCESS){
            throw new IllegalAccessException(result.name());
        }


        //
        hello("John","Montana",value -> {
            System.out.println("no lastName provicded for "+value);
        });
    }
    static void hello(String firstName, String lastName, Consumer<String> callback){
        System.out.println(firstName);
        if (Objects.nonNull(firstName)){
            System.out.println(lastName);
        }else {
            callback.accept(firstName);
        }
    }
}

