package com.ocean.springcloud.oceannetty.ab;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author 季超
 * @create 2018-11-13 15:38
 * @desc
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RoutingSwitch {

    /**
     * 在配置系统中的开关属性名称，应用系统将会实时读取配置系统中对应开关的值来决定是调用哪个版本
     *
     * @return
     */
    String value() default "";
}
