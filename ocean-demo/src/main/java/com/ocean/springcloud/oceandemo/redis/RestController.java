package com.ocean.springcloud.oceandemo.redis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年07月11日 15:41
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    @GetMapping("/listUsers")
    public List<User> listUsers(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User("dachao" + i, "aiwo" + i);
            users.add(user);
        }
        return users;

    }
}
