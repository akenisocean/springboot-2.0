package com.ocean.springcloud.oceanmybaitsplus.excel;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.ocean.springcloud.oceanmybaitsplus.dao.UserMapper;
import com.ocean.springcloud.oceanmybaitsplus.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author chao
 * @version 1.0
 * @desc excel表格操作工具
 * @date 2019年03月21日 16:24
 */
@Slf4j
@Component
public class ExcelCommand {


    public void insertUserManager (String excelPath){
        try {
            //获取导入的Excel workbook
            //
            FileInputStream file = new FileInputStream(new File(excelPath));
            Workbook workbook = WorkbookFactory.create(file);
            //获取sheet1
            List<MapExcelModel> mapModelList = ExcelUtils.excel2Pojo(workbook, MapExcelModel.class, 1);

            //数据填充
            log.info("【添加数据的总量为】：{}", mapModelList.size());
            Date date = new Date();
            final List<User> bachUserList = new ArrayList<>();
            for (int x = 0;x < mapModelList.size();x++) {
                MapExcelModel mapExcelModel = mapModelList.get(x);
                if (StringUtils.isBlank(mapExcelModel.getUName())&& StringUtils.isBlank(mapExcelModel.getULoginName())){
                    break;
                }
                User user = new User();
                user.setUType("3");
                Optional.ofNullable(mapExcelModel.getUEmail()).ifPresent(email -> {if(StringUtils.isNotBlank(email)) {
                    email = email.replaceAll("\r|\n", "");
                    StringUtils.deleteWhitespace(email);
                    user.setUEmail(email);
                }});
                Optional.ofNullable(mapExcelModel.getUTel()).ifPresent(tel -> {if(StringUtils.isNotBlank(tel)) {
                    tel = tel.replaceAll("\r|\n", "");
                    StringUtils.deleteWhitespace(tel);
                    user.setUTel(tel);
                }});
                Optional.ofNullable(mapExcelModel.getUName()).ifPresent(name ->{if(StringUtils.isNotBlank(name)) {
                    name = name.replaceAll("\r|\n", "");
                    StringUtils.deleteWhitespace(name);
                    user.setUName(name);
                }});
                Optional.ofNullable(mapExcelModel.getULoginName()).ifPresent(loginName ->{if(StringUtils.isNotBlank(loginName)) {
                    loginName = loginName.replaceAll("\r|\n", "");
                    StringUtils.deleteWhitespace(loginName);
                    user.setULoginName(loginName);
                }});
                bachUserList.add(user);
            }
            long startTime = System.currentTimeMillis();
            /**
             * 通过jdbc将数据导入数据库
             */
            List<String> duplicateElements = getDuplicateElements(bachUserList, true);
            log.info("重复的数据为",duplicateElements.toString());

            doSendMessage(bachUserList);
            StringBuilder bui = new StringBuilder();
            bachUserList.stream().forEach(s -> {
                bui.append(s.getId() + ",");
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

    @Resource
    UserMapper userMapper;

    public  void doSendMessage(List<User> batchUserList) throws Exception {
        List<String> alredyInsertGroupNameList = new ArrayList<>();
        List<String> duplicateInsertGroupNameList = new ArrayList<>();
        for (User user:batchUserList) {
            try {
                userMapper.insert(user);
                alredyInsertGroupNameList.add(user.getULoginName());
            } catch (Exception e) {
                log.error(e.getMessage());
                duplicateInsertGroupNameList.add(user.getULoginName());
            }
        }
        System.out.println("All down ");
        System.out.println("----------------------------adaadada-----------------------------");
        log.info("已添加用户名称集合:{}",alredyInsertGroupNameList.toString());
        log.info("重复用户名称集合:{}",duplicateInsertGroupNameList.toString());

    }


    public static List<String> getDuplicateElements(List<User> list, boolean flag) {
        return list.stream() //
                .map(e -> { // 获取deptCode或deptAlias的Stream
                    return flag ? e.getULoginName() : e.getUEmail();
                }).collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .entrySet().stream() // 所有 entry 对应的 Stream
                .filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList()); // 转化为 List
    }
}
