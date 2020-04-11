package com.ocean.springcloud.oceanelasticjob;

import com.ocean.springcloud.oceanelasticjob.entity.Order;
import com.ocean.springcloud.oceanelasticjob.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
@Slf4j
class OceanElasticjobApplicationTests {


    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {

    }


    @Test
    public void testInsertOrder(){
    }

}
