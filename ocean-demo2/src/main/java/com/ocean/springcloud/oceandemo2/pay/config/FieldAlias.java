package com.ocean.springcloud.oceandemo2.pay.config;

import java.lang.annotation.*;

/**
 * @author chao
 * @version 1.0
 * @desc 字段别名说明
 * @date 2019年08月30日 15:55
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldAlias {

    /**
     * 字段别名
     * @return
     */
    String alias() default "";

    /**
     * 属性是否必填
     * @return
     */
    boolean must() default false;
}

