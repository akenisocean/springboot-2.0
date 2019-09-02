package com.ocean.springcloud.oceanhystrixconsumer.controller;

import lombok.Data;

/**
 * @author chao
 * @version 1.0
 * @desc 用户
 * @date 2019年07月22日 10:20
 */
@Data
public class User {
    private String id;
    private String userName;
    private String password;
}
