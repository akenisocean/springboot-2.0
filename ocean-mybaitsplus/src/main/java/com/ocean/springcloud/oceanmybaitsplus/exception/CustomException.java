package com.ocean.springcloud.oceanmybaitsplus.exception;

/**
 * @author jack choa
 * @description 自定义消费异常
 */
public class CustomException extends RuntimeException {
  public CustomException(String message) {
    super(message);
  }

  public CustomException(String message, Throwable cause) {
    super(message, cause);
  }
}
