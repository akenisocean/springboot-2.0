package com.ocean.springclouid.druidmybatismultiple.monitor.mapper;

import com.ocean.springclouid.druidmybatismultiple.monitor.entity.Usermedia;
import com.ocean.springclouid.druidmybatismultiple.monitor.entity.UsermediaCriteria;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UsermediaMapper {
    long countByExample(UsermediaCriteria example);

    int deleteByExample(UsermediaCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usermedia record);

    int insertSelective(Usermedia record);

    List<Usermedia> selectByExample(UsermediaCriteria example);

    Usermedia selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Usermedia record, @Param("example") UsermediaCriteria example);

    int updateByExample(@Param("record") Usermedia record, @Param("example") UsermediaCriteria example);

    int updateByPrimaryKeySelective(Usermedia record);

    int updateByPrimaryKey(Usermedia record);
}