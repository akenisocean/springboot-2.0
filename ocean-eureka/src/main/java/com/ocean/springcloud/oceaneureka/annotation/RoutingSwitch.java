package com.ocean.springcloud.oceaneureka.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author 季超
 * @create 2018-11-23 11:23
 * @desc 进行AB测试的切换
 **/
//该注解的作用范围（类，接口（包括注释类型）或枚举声明以及方法上）
@Target({ElementType.TYPE,ElementType.METHOD})
//运行时该注解生效
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RoutingSwitch {

    /**
     * 在配置系统中的开关的属性名称，应用系统将会实时读取配置系统中对应的开关的属性来决定时调用哪个版本
     * @return
     */
    String value() default "";
}
