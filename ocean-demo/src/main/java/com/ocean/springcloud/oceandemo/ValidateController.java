package com.ocean.springcloud.oceandemo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * @author chao
 * @version 1.0
 * @desc 参数验证测试controller层
 * @date 2019年09月03日 9:58
 */
@RestController
@RequestMapping("/validate")
@Validated
public class ValidateController {
    @GetMapping("/getValidate")
    public String getValidate(@Min(value = 3, message = "laji") @RequestParam("haha") int haha) {
        return String.valueOf(haha);
    }

    @PostMapping("/getValidate2")
    public User getValidate(@Valid @RequestBody User user) {

        return user;
    }
}
