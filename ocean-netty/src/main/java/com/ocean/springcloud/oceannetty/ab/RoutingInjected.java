package com.ocean.springcloud.oceannetty.ab;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author 季超
 * @create 2018-11-13 15:37
 * @desc
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RoutingInjected {
}
