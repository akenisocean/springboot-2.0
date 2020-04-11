package com.ocean.springcloud.oceanmail.controller;

import lombok.Data;

/**
 * @author: chao
 * @description:
 * @create: 2020-04-08 19:20
 */
@Data
public class MessageInhibition {
    private String messageCode;
    private String messageStatus;
    private String cause;
}
