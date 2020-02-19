package com.ocean.springclouid.druidmybatismultiple.monitor.mapper;

import com.ocean.springclouid.druidmybatismultiple.monitor.entity.User;
import com.ocean.springclouid.druidmybatismultiple.monitor.entity.UserCriteria;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserCriteria example);

    int deleteByExample(UserCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserCriteria example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByExample(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}