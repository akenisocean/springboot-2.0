package com.ocean.springcloud.oceandemo.controller.幂等测试;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chao
 * @version 1.0
 * @desc 在需要保证 接口幂等性 的Controller的方法上使用此注解
 * @date 2019年08月15日 11:39
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiIdempotent {
}
