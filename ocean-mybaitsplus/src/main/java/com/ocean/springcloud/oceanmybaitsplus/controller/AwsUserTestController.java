package com.ocean.springcloud.oceanmybaitsplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ocean.springcloud.oceanmybaitsplus.dao.AwsUserMapper;
import com.ocean.springcloud.oceanmybaitsplus.entity.AwsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chao
 * @description:
 * @create: 2020-02-06 16:01
 */
@RestController
@RequestMapping("/aws")
public class AwsUserTestController {

    @Autowired
    AwsUserMapper awsUserMapper;
    @GetMapping("/getAll")
    public Page<AwsUser> getAll(){
        QueryWrapper<AwsUser> queryWrapper = new QueryWrapper<>();
        long pageNo = 1;
        long pageSize = 10;
        Page<AwsUser> page = new Page<>(pageNo,pageSize);
        Page<AwsUser> awsUserPage = awsUserMapper.selectPage(page, queryWrapper);
        return awsUserPage;
    }
}
