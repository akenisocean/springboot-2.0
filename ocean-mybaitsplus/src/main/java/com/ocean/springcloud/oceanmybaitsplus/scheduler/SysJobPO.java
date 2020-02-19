package com.ocean.springcloud.oceanmybaitsplus.scheduler;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author: chao
 * @description: 定时任务实体类
 * @create: 2020-02-11 14:53
 */
@Data
public class SysJobPO {
    /**
     * 任务ID
     */
    private Integer jobId;
    /**
     * bean名称
     */
    private String beanName;
    /**
     * 方法名称
     */
    private String methodName;
    /**
     * 方法参数
     */
    private String methodParams;
    /**
     * cron表达式
     */
    private String cronExpression;
    /**
     * 状态（1正常 0暂停）
     */
    private Integer jobStatus;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
