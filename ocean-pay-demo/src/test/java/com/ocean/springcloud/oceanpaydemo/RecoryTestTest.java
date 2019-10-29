package com.ocean.springcloud.oceanpaydemo;

import com.ocean.springcloud.oceanpaydemo.retry.RecoryTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年09月23日 16:36
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecoryTestTest {
    @Autowired
    private RecoryTest recoryTest;

    @Test
    public void retry() {
        recoryTest.retry();
        System.out.println("haha");
    }

    @Test
    public void test() {
        recoryTest.test();
    }
}
