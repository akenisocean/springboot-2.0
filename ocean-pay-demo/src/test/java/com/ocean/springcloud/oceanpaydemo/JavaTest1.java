package com.ocean.springcloud.oceanpaydemo;

import java.util.Optional;

/**
 * @author chao
 * @version 1.0
 * @desc java测试
 * @date 2019年09月15日 11:51
 */
public class JavaTest1 {
    public static void main(String[] args) {
        PersonModel personModel = new PersonModel();
        personModel = null;
        Optional<PersonModel> personModel1 = Optional.ofNullable(personModel);
        System.out.println(personModel1.isPresent());

//        Optional<PersonModel> personOptional = Optional.of(personModel);
//        System.out.println(personOptional.isPresent());


    }


    private static class PersonModel {
        private String name;
        private Integer age;
        private String six;
    }
}
