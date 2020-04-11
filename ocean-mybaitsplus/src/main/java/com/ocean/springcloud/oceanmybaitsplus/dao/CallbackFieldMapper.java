package com.ocean.springcloud.oceanmybaitsplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ocean.springcloud.oceanmybaitsplus.entity.CallbackField;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CallbackFieldMapper extends BaseMapper<CallbackField> {



    @Insert({
            "<script>",
            "INSERT INTO callback_field (BACK_KEY, BACK_VALUE, CREATED_BY,CREATED_TIME,UPDATED_BY,UPDATED_TIME) VALUES ",
            "<foreach collection='list' item='item' index='index' separator=','>",
            "(#{item.backKey}, #{item.backValue}, #{item.createdBy}, #{item.createdTime}, #{item.updatedBy}, #{item.updatedTime})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(@Param("list") List<CallbackField> list);
}