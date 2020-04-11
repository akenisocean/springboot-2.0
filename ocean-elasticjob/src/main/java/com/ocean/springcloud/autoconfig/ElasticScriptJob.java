package com.ocean.springcloud.autoconfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: chao
 * @description:
 * @create: 2020-04-05 21:10
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ElasticScriptJob {
   String jobName()default "";
   String cron()default "";
   int shardingTotalCount()default 1;
   boolean overwrite()default false;
}
