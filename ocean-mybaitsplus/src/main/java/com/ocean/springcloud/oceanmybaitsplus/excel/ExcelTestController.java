package com.ocean.springcloud.oceanmybaitsplus.excel;

import com.ocean.springcloud.oceanmybaitsplus.excel.usergroup.ExcelUserGroupCommand;
import com.ocean.springcloud.oceanmybaitsplus.excel.userrelation.ExcelUserRelationCommand;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: chao
 * @description: excel测试
 * @create: 2020-05-06 17:58
 */
@RestController
@RequestMapping("/excel")
public class ExcelTestController {

    @Resource
    ExcelCommand excelCommand;
    @Resource
    ExcelUserGroupCommand excelUserGroupCommand;
    @Resource
    ExcelUserRelationCommand excelUserRelationCommand;


    @PostMapping("/insertUsers")
    public String insertUsers(@RequestBody ExcelPathRequest request) {
        String excelPath = request.getExcelPath();
        if (!excelPath.endsWith(".xlsx")) {
            return "后缀不正确";
        }
        excelCommand.insertUserManager(excelPath);
        return "倒入数据完成";
    }


    @PostMapping("/insertUserGroups")
    public String insertUserGroups(@RequestBody ExcelPathRequest request) {
        String excelPath = request.getExcelPath();
        if (!excelPath.endsWith(".xlsx")) {
            return "后缀不正确";
        }
        excelUserGroupCommand.insertUserGroupManager(excelPath);
        return "倒入数据完成";
    }

    @PostMapping("/insertUserRelation")
    public String insertUserRelation(@RequestBody ExcelPathRequest request) {
        String excelPath = request.getExcelPath();
        if (!excelPath.endsWith(".xlsx")) {
            return "后缀不正确";
        }
        excelUserRelationCommand.insertUserRelationManager(excelPath);
        return "倒入数据完成";
    }
}
