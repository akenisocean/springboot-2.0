package com.ocean.springcloud.oceanprometheus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chao
 * @description:
 * @create: 2020-10-25 14:55
 */
@RestController
public class CounterController {
    @Autowired
    private JobMetrics jobMetrics;

    @RequestMapping(value = "/counter1", method= RequestMethod.GET)
    public void counter1() {
        jobMetrics.job2Counter.increment();
    }

    @RequestMapping(value = "/counter2", method= RequestMethod.GET)
    public void counter2() {
        jobMetrics.job2Counter.increment();
    }
    @RequestMapping(value = "/gauge", method= RequestMethod.GET)
    public void gauge(@RequestParam(value = "x") String x) {
        System.out.println("gauge controller x"+x);
        jobMetrics.map.put("x",Double.valueOf(x));
    }
}