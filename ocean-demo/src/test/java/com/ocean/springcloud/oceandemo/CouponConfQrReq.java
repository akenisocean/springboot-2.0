package com.ocean.springcloud.oceandemo;

import lombok.Data;

/**
 * @author chao
 * @version 1.0
 * @desc 优惠券配置查询
 * @date 2019年10月14日 17:02
 */
@Data
public class CouponConfQrReq {
    /**优惠券编号*/
    private Integer id;
    /**优惠券名称*/
    private String name;
    /**优惠券类型*/
    private Integer couponType;

    private Integer status;
    /**页码*/
    private Integer pageIndex = 1;
    /**页大小*/
    private Integer pageSize = 20;
}
