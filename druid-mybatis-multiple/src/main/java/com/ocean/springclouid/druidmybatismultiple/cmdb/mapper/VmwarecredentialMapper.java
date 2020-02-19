package com.ocean.springclouid.druidmybatismultiple.cmdb.mapper;

import com.ocean.springclouid.druidmybatismultiple.cmdb.entity.Vmwarecredential;
import com.ocean.springclouid.druidmybatismultiple.cmdb.entity.VmwarecredentialCriteria;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface VmwarecredentialMapper {
    long countByExample(VmwarecredentialCriteria example);

    int deleteByExample(VmwarecredentialCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Vmwarecredential record);

    int insertSelective(Vmwarecredential record);

    List<Vmwarecredential> selectByExample(VmwarecredentialCriteria example);

    Vmwarecredential selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Vmwarecredential record, @Param("example") VmwarecredentialCriteria example);

    int updateByExample(@Param("record") Vmwarecredential record, @Param("example") VmwarecredentialCriteria example);

    int updateByPrimaryKeySelective(Vmwarecredential record);

    int updateByPrimaryKey(Vmwarecredential record);
}