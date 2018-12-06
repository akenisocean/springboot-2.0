package com.ocean.springcloud.oceannetty.ab;

/**
 * @author 季超
 * @create 2018-11-13 15:41
 * @desc
 **/
@RoutingSwitch("hello.switch")
public interface HelloService {

    @RoutingSwitch("A")
    void sayHello();

    void sayHi();
}
