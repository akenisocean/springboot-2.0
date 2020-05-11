package com.ocean.springcloud.oceanmybaitsplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: lhc
 * @Date: 2020/1/11 13:35
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("user_manager")
public class User implements Serializable {
    private Long id;

    private String uName;

    private String uLoginName;

    private String uImage;

    private String uWechat;

    private String uEmail;

    private String uTel;

    private String uOgz;

    private String uDpm;

    private String uTeam;

    private String uNum;

    private String uPassword;

    private String uContent;

    private String uType;

}
