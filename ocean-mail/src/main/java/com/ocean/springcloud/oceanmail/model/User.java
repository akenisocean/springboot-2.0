package com.ocean.springcloud.oceanmail.model;

/**
 * @author: chao
 * @description:
 * @create: 2020-01-07 13:07
 */
public class User {

    private Integer age ;

    private String name ;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}