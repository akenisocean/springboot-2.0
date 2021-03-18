package com.ocean.springcloud.oceanshiro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @author chao
 * @description 用户
 * @create 2020-12-22 13:06
 */

@Data
@AllArgsConstructor
public class User {
    private String id;
    private String userName;
    private String password;
    /**
     * 用户对应的角色集合
     */
    private Set<Role> roles;
}
