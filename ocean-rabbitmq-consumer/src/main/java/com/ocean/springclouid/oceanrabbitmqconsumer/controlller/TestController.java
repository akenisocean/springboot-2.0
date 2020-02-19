package com.ocean.springclouid.oceanrabbitmqconsumer.controlller;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author chao
 * @version 1.0
 * @desc 测试controller
 * @date 2019年04月01日 22:28
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/book")
    public ResponseEntity<Book> showBook() {
        Book book = Book.builder().name("java开发从入门到放弃").price(new BigDecimal("25.66").doubleValue()).build();
        return ResponseEntity.ok().cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS))
                .eTag("1.1")
                .body(book);
    }

}
