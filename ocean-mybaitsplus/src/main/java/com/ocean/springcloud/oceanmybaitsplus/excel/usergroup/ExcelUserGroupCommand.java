package com.ocean.springcloud.oceanmybaitsplus.excel.usergroup;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.ocean.springcloud.oceanmybaitsplus.dao.UserGroupMapper;
import com.ocean.springcloud.oceanmybaitsplus.entity.UserGroup;
import com.ocean.springcloud.oceanmybaitsplus.excel.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chao
 * @version 1.0
 * @desc excel表格操作工具
 * @date 2019年03月21日 16:24
 */
@Slf4j
@Component
public class ExcelUserGroupCommand {


    @Resource
    UserGroupMapper userGroupMapper;


    public void insertUserGroupManager(String excelPath) {
        try {
            //获取导入的Excel workbook
            //
            FileInputStream file = new FileInputStream(new File(excelPath));
            Workbook workbook = WorkbookFactory.create(file);
            //获取sheet0
            List<MapExceUserGroupModel> mapModelList = ExcelUtils.excel2Pojo(workbook, MapExceUserGroupModel.class, 0);

            //数据填充
            log.info("【添加数据的总量为】：{}", mapModelList.size());
            Date date = new Date();
            final List<UserGroup> bachUserGroupList = new ArrayList<>();
            for (int x = 0; x < mapModelList.size(); x++) {
                MapExceUserGroupModel model = mapModelList.get(x);
                UserGroup userGroup = new UserGroup();
                userGroup.setUType("3");
                userGroup.setGroupName(model.getGroupName());

                bachUserGroupList.add(userGroup);
            }
            long startTime = System.currentTimeMillis();
            /**
             * 通过jdbc将数据导入数据库
             */

            doSendMessage(bachUserGroupList);
            StringBuilder bui = new StringBuilder();
            bachUserGroupList.stream().forEach(s -> {
                bui.append(s.getGroupId() + ",");
            });
            long endTime = System.currentTimeMillis();
            log.info("添加的id为:{}", bui.toString());
            log.info("耗时：{}", (endTime - startTime));
        } catch (InvalidFormatException e) {
            log.error("上传文件出错,{}", e);
        } catch (Exception e) {
            log.error("上传文件出错,{}", e);
        }
    }


    public void doSendMessage(List<UserGroup> bachUserGroupList) throws Exception {
        List<String> alredyInsertGroupNameList = new ArrayList<>();
        List<String> duplicateInsertGroupNameList = new ArrayList<>();
        for (UserGroup userGroup : bachUserGroupList) {
            try {
                userGroupMapper.insert(userGroup);
                log.info("添加用户组id:{}，用户组名称:{}成功",userGroup.getGroupId(),userGroup.getGroupName());
                alredyInsertGroupNameList.add(userGroup.getGroupName());
            } catch (Exception e) {
                log.error(e.getMessage());
                duplicateInsertGroupNameList.add(userGroup.getGroupName());
            }

        }
        System.out.println("All down ");
        System.out.println("----------------------------adaadada-----------------------------");
        log.info("已添加用户组名称集合:{}",alredyInsertGroupNameList.toString());
        log.info("重复用户组名称集合:{}",duplicateInsertGroupNameList.toString());

    }


}
