package com.ocean.springcloud.oceanmybaitsplus.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.io.Serializable;

/**
 * @program: middle-datacollection
 * @description:
 * @author: DengMin
 * @create: 2020-01-05 16:03
 **/
@Data
@Builder
public class AwsUser implements Serializable,Cloneable{
    /** id */
    private Long id ;
    /** access_key */
    private String accessKey ;
    /** secret_key */
    private String secretKey ;
    /** 地区编码 */
    private String region ;

    @Tolerate
    public AwsUser() {
    }
}