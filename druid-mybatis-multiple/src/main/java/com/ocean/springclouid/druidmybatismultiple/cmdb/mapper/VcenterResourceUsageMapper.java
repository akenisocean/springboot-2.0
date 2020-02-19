package com.ocean.springclouid.druidmybatismultiple.cmdb.mapper;

import com.ocean.springclouid.druidmybatismultiple.cmdb.entity.VcenterResourceUsage;
import com.ocean.springclouid.druidmybatismultiple.cmdb.entity.VcenterResourceUsageCriteria;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface VcenterResourceUsageMapper {
    long countByExample(VcenterResourceUsageCriteria example);

    int deleteByExample(VcenterResourceUsageCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(VcenterResourceUsage record);

    int insertSelective(VcenterResourceUsage record);

    List<VcenterResourceUsage> selectByExample(VcenterResourceUsageCriteria example);

    VcenterResourceUsage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VcenterResourceUsage record, @Param("example") VcenterResourceUsageCriteria example);

    int updateByExample(@Param("record") VcenterResourceUsage record, @Param("example") VcenterResourceUsageCriteria example);

    int updateByPrimaryKeySelective(VcenterResourceUsage record);

    int updateByPrimaryKey(VcenterResourceUsage record);
}