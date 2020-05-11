package com.ocean.springcloud.oceanmybaitsplus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ocean.springcloud.oceanmybaitsplus.dao.AwsUserMapper;
import com.ocean.springcloud.oceanmybaitsplus.entity.AwsUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chao
 * @description:
 * @create: 2020-04-26 12:54
 */
@Service
public class AwsUserServiceImpl extends ServiceImpl<AwsUserMapper, AwsUser> implements AwsUserService {


    @Override
    public boolean batchInsertAwsUser(List<AwsUser> awsUsers) {
        boolean b = saveBatch(awsUsers);
        return b;
    }
}
