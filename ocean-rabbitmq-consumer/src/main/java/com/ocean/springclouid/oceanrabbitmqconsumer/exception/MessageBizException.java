package com.ocean.springclouid.oceanrabbitmqconsumer.exception;

/**
 * @author chao
 * @version 1.0
 * @desc 消息业务异常
 * @date 2019年06月03日 14:50
 */
public class MessageBizException extends RuntimeException {

    public MessageBizException() {
    }

    public MessageBizException(String message) {
        super(message);
    }

}
