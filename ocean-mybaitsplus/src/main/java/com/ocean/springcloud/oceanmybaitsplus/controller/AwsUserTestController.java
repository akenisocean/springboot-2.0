package com.ocean.springcloud.oceanmybaitsplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ocean.springcloud.oceanmybaitsplus.dao.AwsUserMapper;
import com.ocean.springcloud.oceanmybaitsplus.dao.CallbackFieldMapper;
import com.ocean.springcloud.oceanmybaitsplus.entity.AwsUser;
import com.ocean.springcloud.oceanmybaitsplus.entity.CallbackField;
import com.ocean.springcloud.oceanmybaitsplus.rsa.RSAUtils;
import com.ocean.springcloud.oceanmybaitsplus.service.AwsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author: chao
 * @description:
 * @create: 2020-02-06 16:01
 */
@RestController
@RequestMapping("/aws")
public class AwsUserTestController {

    public static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIIlQbOdc5qvvHq0o1Y0vpY4r2/6FKs9zoY/wml5jDvjPO2LYO/y3Fb/kIf4qNcQL6Rtujp1M8cH0NDObCZS8HJbM+E9WpadowfMEd6NoL8lNOG7pn242WRyGpBSqMWpR8+0+UIEt2B7CczHQLWaqzzox3C7z76T4NwrTgBc66FfAgMBAAECgYBEfMaudtU3OfO9vwGVg/wnoXzxOHFYDBZ6n2L3jnc1rMeLWiWRIATD44lzhG+VfXcU2Il/6d1th7djqr1PDaZqPM2nhGrE4LvYtD2DhUJnne674OJlhd4fYyRBarLqV+uvByHeHV7BytO2bsYxcLe46jo6ufKrZKJEDjOpf3q9gQJBAP4UP0+QWwMb9Kf42KEHb+M6/DEb7hopYf/nL8FiXB4uRYE1Cx8SbKt7x7UJsUEJJHKEk4fI+5r5F4yO49rW09cCQQCDIST4wkQRw2WuxS0YrSqs4LRvLbKnY8g9zEEpYc9OAmNne32guVOz12hmgSAXDmXiBJgM6ZCe5ewMA2dtFm25AkEArvWwVxCXq39vrM9OFSzy3i17BjIudrNyeW5wUyFxP5MrZ3roSqA8VqWo8sBW3+r0vysOEF3U7HWEwtSOkN6IBwJAVAwsfF1X7+LEC+9J5mUn00L7o78woWWtdR60LWgJzcBuImfer+PZqI3K1tiwztZlqyaypqQWFCLe1xxfcGZN0QJARY11QnXfgQNQGT6w/M33K7ozRdoB4sBuRIeaPKe2PTbbpuCLfchteQeYrQQnNNpJARtunhey8yUq1avHAstNJg==";
    public static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCCJUGznXOar7x6tKNWNL6WOK9v+hSrPc6GP8JpeYw74zzti2Dv8txW/5CH+KjXEC+kbbo6dTPHB9DQzmwmUvByWzPhPVqWnaMHzBHejaC/JTThu6Z9uNlkchqQUqjFqUfPtPlCBLdgewnMx0C1mqs86Mdwu8++k+DcK04AXOuhXwIDAQAB";

    @Autowired
    AwsUserMapper awsUserMapper;
    @Autowired
    CallbackFieldMapper callbackFieldMapper;

    @GetMapping("/getAll")
    public PageInfo<AwsUser> getAll() {
        QueryWrapper<AwsUser> queryWrapper = new QueryWrapper<>();
        int pageNo = 1;
        int pageSize = 1;
        PageHelper.startPage(pageNo, pageSize);
        List<AwsUser> awsUsers = awsUserMapper.selectList(queryWrapper);
        PageInfo<AwsUser> awsUserPageInfo = new PageInfo<>(awsUsers, pageSize);
        return awsUserPageInfo;
    }

    @GetMapping("/getAll2")
    public List<AwsUser> getAll2() {
        QueryWrapper<AwsUser> queryWrapper = new QueryWrapper<>();
        List<AwsUser> awsUsers = awsUserMapper.selectList(queryWrapper);
        return awsUsers;
    }


    @Autowired
    AwsUserService awsUserService;
    @PostMapping("/awsUserService")
    public List<AwsUser> getAll2(@RequestBody List<AwsUser> awsUsers) {
        awsUserService.batchInsertAwsUser(awsUsers);
        return awsUsers;
    }


    @GetMapping("/getAll3")
    public void getAll3() {
        for (int i = 0; i < 5; i++) {
            CallbackField callbackField = CallbackField.builder().backKey(i + "callback")
                    .createdBy("user" + i)
                    .build();
            int insert = callbackFieldMapper.insert(callbackField);
            System.out.println(insert);

        }

    }

}
