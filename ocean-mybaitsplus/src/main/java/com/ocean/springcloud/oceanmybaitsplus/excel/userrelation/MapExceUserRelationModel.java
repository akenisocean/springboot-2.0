package com.ocean.springcloud.oceanmybaitsplus.excel.userrelation;

import com.ocean.springcloud.oceanmybaitsplus.excel.MapDetailParent;
import com.ocean.springcloud.oceanmybaitsplus.excel.PropertiesName;
import lombok.Data;

/**
 * @author chao
 * @create 2018-08-17 13:55
 * @desc Excel2Pojo的实体类
 **/
@Data
public class MapExceUserRelationModel extends MapDetailParent {
    @PropertiesName(name = "用户组")
    private String groupName;

    @PropertiesName(name = "域账号1")
    private String loginName1;

    @PropertiesName(name = "域账号2")
    private String loginName2;

    @PropertiesName(name = "域账号3")
    private String loginName3;

    @PropertiesName(name = "域账号4")
    private String loginName4;

    @PropertiesName(name = "域账号5")
    private String loginName5;

    @PropertiesName(name = "域账号6")
    private String loginName6;

    @PropertiesName(name = "域账号7")
    private String loginName7;

    @PropertiesName(name = "域账号8")
    private String loginName8;

    @PropertiesName(name = "域账号9")
    private String loginName9;

    @PropertiesName(name = "域账号10")
    private String loginName10;

    @PropertiesName(name = "域账号11")
    private String loginName11;

}
