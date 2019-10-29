package com.ocean.springcloud.oceandemo.async;

import com.ocean.springcloud.oceandemo.async.config.AsyncThreadConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年09月05日 13:12
 */
@Service
@Slf4j
public class AsyncService {


    @Async(value = AsyncThreadConfig.ASYNC_EXECUTOR_NAME)
    public void test1(){
       log.info("Async.test1线程开始了");
    }


    @Async(value = AsyncThreadConfig.ASYNC_EXECUTOR_NAME)
    public Future<String> test2(){
        log.info("Async.test2线程开始了");
        return new AsyncResult<>("发送消息用了+test2秒");
    }
}
