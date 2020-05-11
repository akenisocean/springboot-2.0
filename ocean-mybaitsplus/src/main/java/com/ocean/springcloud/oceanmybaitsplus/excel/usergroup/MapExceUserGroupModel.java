package com.ocean.springcloud.oceanmybaitsplus.excel.usergroup;

import com.ocean.springcloud.oceanmybaitsplus.excel.MapDetailParent;
import com.ocean.springcloud.oceanmybaitsplus.excel.PropertiesName;
import lombok.Data;

/**
 * @author chao
 * @create 2018-08-17 13:55
 * @desc Excel2Pojo的实体类
 **/
@Data
public class MapExceUserGroupModel extends MapDetailParent {
    @PropertiesName(name = "用户组表")
    private String groupName;

}
