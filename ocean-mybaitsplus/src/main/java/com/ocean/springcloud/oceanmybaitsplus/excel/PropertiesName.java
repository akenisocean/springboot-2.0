package com.ocean.springcloud.oceanmybaitsplus.excel;

import java.lang.annotation.*;

/**
 * 给Bean属性上加上名称
 * 
 * @author chao
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PropertiesName {

	 String name();
	
}
