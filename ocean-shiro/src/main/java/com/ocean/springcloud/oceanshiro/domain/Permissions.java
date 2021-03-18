package com.ocean.springcloud.oceanshiro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chao
 * @description 权限
 * @create 2020-12-22 13:05
 */
@Data
@AllArgsConstructor
public class Permissions {
    private String id;
    private String permissionsName;
}
