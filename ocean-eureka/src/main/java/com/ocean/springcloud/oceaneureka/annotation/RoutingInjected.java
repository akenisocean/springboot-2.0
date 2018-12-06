package com.ocean.springcloud.oceaneureka.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author 季超
 * @create 2018-11-23 11:18
 * @desc  进行项目代码的AB测试
 **/
//  注解的使用范围(类，接口（包括注释类型）或枚举可以使用)
@Target({ElementType.FIELD})
//运行时该注解生效
@Retention(RetentionPolicy.RUNTIME)
// 可以编译成文档
@Documented
// 表示这是一个java组件
@Component
public @interface RoutingInjected {

}
