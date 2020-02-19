package com.ocean.springcloud.oceannetty.ab;

import org.springframework.stereotype.Controller;

/**
 * @author 季超
 * @create 2018-11-13 15:42
 * @desc
 **/
@Controller
public class HelloController {


    @RoutingInjected
    private HelloService helloService;

    public void sayHello() {
        this.helloService.sayHello();
    }

    public void sayHi() {
        this.helloService.sayHi();
    }
}
