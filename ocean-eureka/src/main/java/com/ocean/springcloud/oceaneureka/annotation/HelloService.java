package com.ocean.springcloud.oceaneureka.annotation;

import com.ocean.springcloud.oceaneureka.annotation.impl.RoutingValueConfig;

/**
 * @author 季超
 * @create 2018-11-23 11:29
 * @desc
 **/
@RoutingSwitch("hello.service")
public interface HelloService {








    /**
     * 该RoutingSwitch种的value可以修改为从配置中心种获取，这样就实现了线上AB测试的操作.
     * RoutingValueConfig.routingValue
     */
    @RoutingSwitch("A")
    void sayHello();

    void sayHi();
}
