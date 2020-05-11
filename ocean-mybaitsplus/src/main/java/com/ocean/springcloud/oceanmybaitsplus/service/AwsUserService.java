package com.ocean.springcloud.oceanmybaitsplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ocean.springcloud.oceanmybaitsplus.dao.AwsUserMapper;
import com.ocean.springcloud.oceanmybaitsplus.entity.AwsUser;

import java.util.List;

/**
 * @author: chao
 * @description:
 * @create: 2020-04-26 12:54
 */
public interface AwsUserService extends IService<AwsUser> {


    boolean batchInsertAwsUser(List<AwsUser> awsUsers);
}
