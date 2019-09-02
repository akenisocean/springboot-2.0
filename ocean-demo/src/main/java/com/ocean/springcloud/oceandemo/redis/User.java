package com.ocean.springcloud.oceandemo.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年07月11日 15:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String password;
}
