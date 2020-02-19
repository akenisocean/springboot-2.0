package com.ocean.springcloud.oceanldap.exception;

import com.ocean.common.api.ResultCode;
import lombok.Getter;

/**
 * @author: chao
 * @description: 自定义服务端异常
 * @create: 2019-12-23 15:09
 */
public class ServiceException extends RuntimeException {
    @Getter
    private int errcode;
    @Getter
    private String errmsg;
    public ServiceException(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getMsg());
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Integer errcode, String errmsg) {
        super(errmsg);
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
