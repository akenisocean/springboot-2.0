package com.ocean.springcloud.oceanshiro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @author chao
 * @description 角色
 * @create 2020-12-22 13:05
 */
@Data
@AllArgsConstructor
public class Role {

    private String id;
    private String roleName;
    /**
     * 角色对应权限集合
     */
    private Set<Permissions> permissions;
}
