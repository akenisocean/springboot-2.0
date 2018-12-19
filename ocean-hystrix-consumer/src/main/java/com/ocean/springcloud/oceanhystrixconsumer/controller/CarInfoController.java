package com.ocean.springcloud.oceanhystrixconsumer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 季超
 * @create 2018-12-11 11:44
 * @desc
 **/
@RestController
@RequestMapping("/carInfoDevice")
public class CarInfoController {

    @PostMapping(value = "/getFirstCarInfo")
    public void getFirstCarInfo(HttpServletRequest request, @RequestParam Map<String, String> params){

        System.out.println(request.getCharacterEncoding());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = request.getHeader(headerNames.nextElement());
            System.out.println(header);
        }

        Set<Map.Entry<String, String>> entries = params.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }


    }
}
