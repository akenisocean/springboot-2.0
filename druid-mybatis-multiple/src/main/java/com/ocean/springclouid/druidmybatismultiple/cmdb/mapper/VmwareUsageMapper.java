package com.ocean.springclouid.druidmybatismultiple.cmdb.mapper;

import com.ocean.springclouid.druidmybatismultiple.cmdb.entity.VmwareUsage;
import com.ocean.springclouid.druidmybatismultiple.cmdb.entity.VmwareUsageCriteria;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface VmwareUsageMapper {
    long countByExample(VmwareUsageCriteria example);

    int deleteByExample(VmwareUsageCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(VmwareUsage record);

    int insertSelective(VmwareUsage record);

    List<VmwareUsage> selectByExample(VmwareUsageCriteria example);

    VmwareUsage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VmwareUsage record, @Param("example") VmwareUsageCriteria example);

    int updateByExample(@Param("record") VmwareUsage record, @Param("example") VmwareUsageCriteria example);

    int updateByPrimaryKeySelective(VmwareUsage record);

    int updateByPrimaryKey(VmwareUsage record);
}