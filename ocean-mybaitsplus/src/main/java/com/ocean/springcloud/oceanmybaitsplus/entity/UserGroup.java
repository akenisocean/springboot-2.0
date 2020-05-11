package com.ocean.springcloud.oceanmybaitsplus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: lhc
 * @Date: 2020/1/11 13:36
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserGroup implements Serializable {

    private Long groupId;

    private String groupName;

    private Integer status;

}
