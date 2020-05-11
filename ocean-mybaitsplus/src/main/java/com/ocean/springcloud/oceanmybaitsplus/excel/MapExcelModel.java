package com.ocean.springcloud.oceanmybaitsplus.excel;

import lombok.Data;

/**
 * @author chao
 * @create 2018-08-17 13:55
 * @desc Excel2Pojo的实体类
 **/
@Data
public class MapExcelModel extends MapDetailParent {
    @PropertiesName(name = "用户名")
    private String uName;
    @PropertiesName(name = "域账号")
    private String uLoginName;
    @PropertiesName(name = "邮箱")
    private String uEmail;
    @PropertiesName(name = "电话")
    private String uTel;


}
