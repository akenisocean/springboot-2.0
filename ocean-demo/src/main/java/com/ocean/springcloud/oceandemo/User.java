package com.ocean.springcloud.oceandemo;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年09月05日 14:24
 */
@Data
public class User {
    @Min(value = 18,message = "未成年禁止入内")
    private Integer age;
}
