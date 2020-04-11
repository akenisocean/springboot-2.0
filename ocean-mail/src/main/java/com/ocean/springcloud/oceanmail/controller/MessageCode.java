package com.ocean.springcloud.oceanmail.controller;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author: chao
 * @description:
 * @create: 2020-03-27 16:33
 */
@Data
@Builder
public class MessageCode {
    private List<String> list;
    private List<MessageInhibition> inhibitions;
}
