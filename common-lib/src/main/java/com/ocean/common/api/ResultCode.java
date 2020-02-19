package com.ocean.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: chao
 * @description: 统一返回状态码
 * @create: 2019-12-23 15:42
 */
@Getter
@AllArgsConstructor
public enum  ResultCode {
    /**
     * 接口调用成功
     */
    SUCCESS(0, "Request Successful"),

    /**
     * 服务器暂不可用，建议稍候重试。建议重试次数不超过3次。
     */
    FAILURE(-1, "System Busy");

    final int code;

    final String msg;
}
