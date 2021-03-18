package com.ocean.springcloud.oceanmybaitsplus.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author: chao
 * @description: 用户关联
 * @create: 2020-03-05 18:39
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserRelation implements Serializable {
    private Long uId;
    private Long ugroupId;
    private String uType;
}
