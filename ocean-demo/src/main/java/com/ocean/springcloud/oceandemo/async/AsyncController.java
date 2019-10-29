package com.ocean.springcloud.oceandemo.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年09月05日 13:11
 */
@RestController
@RequestMapping("/async")
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncService asyncService;


    @GetMapping("/test1")
    public void test1(){
      log.info("test1线程开始了");
        asyncService.test1();
        Future<String> stringFuture = asyncService.test2();
        try {
            log.info(stringFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
