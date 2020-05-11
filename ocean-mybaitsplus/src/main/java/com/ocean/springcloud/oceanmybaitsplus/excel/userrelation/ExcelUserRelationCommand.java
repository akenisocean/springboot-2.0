package com.ocean.springcloud.oceanmybaitsplus.excel.userrelation;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.ocean.springcloud.oceanmybaitsplus.dao.UserGroupMapper;
import com.ocean.springcloud.oceanmybaitsplus.dao.UserMapper;
import com.ocean.springcloud.oceanmybaitsplus.dao.UserRelationMapper;
import com.ocean.springcloud.oceanmybaitsplus.entity.User;
import com.ocean.springcloud.oceanmybaitsplus.entity.UserGroup;
import com.ocean.springcloud.oceanmybaitsplus.entity.UserRelation;
import com.ocean.springcloud.oceanmybaitsplus.excel.ExcelUtils;
import com.ocean.springcloud.oceanmybaitsplus.exception.CustomException;
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

/**
 * @author chao
 * @version 1.0
 * @desc excel表格操作工具
 * @date 2019年03月21日 16:24
 */
@Slf4j
@Component
public class ExcelUserRelationCommand {

    @Resource
    UserGroupMapper userGroupMapper;
    @Resource
    UserRelationMapper userRelationMapper;
    @Resource
    UserMapper userMapper;


    public void insertUserRelationManager(String excelPath) {
        try {
            //获取导入的Excel workbook
            FileInputStream file = new FileInputStream(new File(excelPath));
            Workbook workbook = WorkbookFactory.create(file);
            //获取sheet0
            List<MapExceUserRelationModel> mapModelList = ExcelUtils.excel2Pojo(workbook, MapExceUserRelationModel.class, 2);
            //数据填充
            log.info("【添加数据的总量为】：{}", mapModelList.size());
            Date date = new Date();
            final List<UserRelation> bachUserRelationList = new ArrayList<>();
            //组装用户关联表数据
            for (int x = 0; x < mapModelList.size(); x++) {
                MapExceUserRelationModel model = mapModelList.get(x);
                //1. 根据组名称查询对应的用户组id
                QueryWrapper<UserGroup> queryWrapper = new QueryWrapper<>();
                queryWrapper.lambda().eq(UserGroup::getGroupName, model.getGroupName());
                UserGroup userGroup = userGroupMapper.selectOne(queryWrapper);
                Optional<Long> userGroupIdOption = Optional.ofNullable(userGroup).map(ug -> ug.getGroupId());
                if (userGroupIdOption.isPresent()) {
                    Long ugroupId = userGroupIdOption.get();
                    //查询所有的域账号
                    if(StringUtils.isNotBlank(model.getLoginName1())){
                        String loginName = model.getLoginName1();
                        Long uId = getUserIdByUserLoginName(loginName);
                        UserRelation userRe = UserRelation.builder().uId(uId).ugroupId(ugroupId).build();
                        bachUserRelationList.add(userRe);
                    }

                    if(StringUtils.isNotBlank(model.getLoginName2())){
                        String loginName = model.getLoginName2();
                        Long uId = getUserIdByUserLoginName(loginName);
                        UserRelation userRe = UserRelation.builder().uId(uId).ugroupId(ugroupId).build();
                        bachUserRelationList.add(userRe);
                    }

                    if(StringUtils.isNotBlank(model.getLoginName3())){
                        String loginName = model.getLoginName3();
                        Long uId = getUserIdByUserLoginName(loginName);
                        UserRelation userRe = UserRelation.builder().uId(uId).ugroupId(ugroupId).build();
                        bachUserRelationList.add(userRe);
                    }

                    if(StringUtils.isNotBlank(model.getLoginName4())){
                        String loginName = model.getLoginName4();
                        Long uId = getUserIdByUserLoginName(loginName);
                        UserRelation userRe = UserRelation.builder().uId(uId).ugroupId(ugroupId).build();
                        bachUserRelationList.add(userRe);
                    }

                    if(StringUtils.isNotBlank(model.getLoginName5())){
                        String loginName = model.getLoginName5();
                        Long uId = getUserIdByUserLoginName(loginName);
                        UserRelation userRe = UserRelation.builder().uId(uId).ugroupId(ugroupId).build();
                        bachUserRelationList.add(userRe);
                    }

                    if(StringUtils.isNotBlank(model.getLoginName6())){
                        String loginName = model.getLoginName6();
                        Long uId = getUserIdByUserLoginName(loginName);
                        UserRelation userRe = UserRelation.builder().uId(uId).ugroupId(ugroupId).build();
                        bachUserRelationList.add(userRe);
                    }

                    if(StringUtils.isNotBlank(model.getLoginName7())){
                        String loginName = model.getLoginName7();
                        Long uId = getUserIdByUserLoginName(loginName);
                        UserRelation userRe = UserRelation.builder().uId(uId).ugroupId(ugroupId).build();
                        bachUserRelationList.add(userRe);
                    }

                    if(StringUtils.isNotBlank(model.getLoginName8())){
                        String loginName = model.getLoginName8();
                        Long uId = getUserIdByUserLoginName(loginName);
                        UserRelation userRe = UserRelation.builder().uId(uId).ugroupId(ugroupId).build();
                        bachUserRelationList.add(userRe);
                    }

                    if(StringUtils.isNotBlank(model.getLoginName9())){
                        String loginName = model.getLoginName9();
                        Long uId = getUserIdByUserLoginName(loginName);
                        UserRelation userRe = UserRelation.builder().uId(uId).ugroupId(ugroupId).build();
                        bachUserRelationList.add(userRe);
                    }

                    if(StringUtils.isNotBlank(model.getLoginName10())){
                        String loginName = model.getLoginName10();
                        Long uId = getUserIdByUserLoginName(loginName);
                        UserRelation userRe = UserRelation.builder().uId(uId).ugroupId(ugroupId).build();
                        bachUserRelationList.add(userRe);
                    }

                    if(StringUtils.isNotBlank(model.getLoginName11())){
                        String loginName = model.getLoginName11();
                        Long uId = getUserIdByUserLoginName(loginName);
                        UserRelation userRe = UserRelation.builder().uId(uId).ugroupId(ugroupId).build();
                        bachUserRelationList.add(userRe);
                    }

                } else {
                    new CustomException("查询用户组:" + model.getGroupName() + "对应的id不存在");
                }


            }
            long startTime = System.currentTimeMillis();
            /**
             * 通过jdbc将数据导入数据库
             */

            doSendMessage(bachUserRelationList);
            long endTime = System.currentTimeMillis();
            log.info("耗时：{}", (endTime - startTime));
        } catch (InvalidFormatException e) {
            log.error("上传文件出错,{}", e);
        } catch (Exception e) {
            log.error("上传文件出错,{}", e);
        }

    }

    private void doSendMessage(List<UserRelation> batchUserRelationList) {
        batchUserRelationList.forEach(userRelation -> {
            try {
                userRelationMapper.insert(userRelation);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        });
    }


    public Long getUserIdByUserLoginName(String loginName){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getULoginName,loginName);
        User user = userMapper.selectOne(queryWrapper);
        Optional<Long> uIdOption = Optional.ofNullable(user).map(u -> u.getId());
        if(uIdOption.isPresent()){
           return  uIdOption.get();
        }else{
           throw new CustomException("查询用户登录名:"+loginName+"不存在");
        }

    }

}
