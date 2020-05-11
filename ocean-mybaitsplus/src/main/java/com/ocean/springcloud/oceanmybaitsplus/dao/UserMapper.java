package com.ocean.springcloud.oceanmybaitsplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ocean.springcloud.oceanmybaitsplus.entity.User;
import com.ocean.springcloud.oceanmybaitsplus.entity.UserGroup;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: lhc
 * @Date: 2020/1/11 13:38
 * @Version 1.0
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> getAllUser();

    List<UserGroup> getAllUserGroup();


    @Select("<script>" +
            "SELECT id as id,u_name as uName,u_wechat as uWechat,u_email as uEmail,u_tel as uTel "+
            "FROM " +
            "user_manager  " +
            "WHERE " +
            "id IN (" +
            "<foreach collection=\"value\" item=\"data\" index=\"index\" open=\"\" close='' separator=','> " +
            "#{data}" +
            "</foreach>" +
            ");" +
            "</script>")
    List<User> getUserByUserIds(@Param("value") List<Integer> userIds);

    @Select("<script>" +
            "select id ,name from user  where id = #{id};" +
            "</script>")
    User getById(@Param("id") Long id);
}

