package com.ocean.springcloud.oceanelasticsearch.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author: chao
 * @description: 资源监控告警信息
 * @create: 2020-12-03 13:12
 */

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "alert_message")
public class AlertMessage {


    @Id
    private String id;

    /**
     * 告警类型
     */
    private String type;

    /**
     * 数据源名称
     */
    private String dataSourceName;

    /**
     * 当前检测值
     */
    private String detectKey;

    /**
     * 事件id
     */
    private Integer eventId;

    /**
     * 主机id
     */
    private Integer hostId;

    /**
     * 主机Ip
     */
    private String hostIp;

    /**
     * 告警等级
     */
    private String level;

    /**
     * 告警信息
     */
    private String info;

    /**
     * 触发器Id
     */
    private Integer triggerId;

    /**
     * 告警事件 单位：秒
     */
    private Date currentTime;

    /**
     * 告警恢复事件 单位: 秒
     */
    @Field(type = FieldType.Date,format = DateFormat.custom,pattern = "epoch_second")
    private Date recoveryTime;

    /**
     * 资源标签,多个使用逗号分隔
     */
    private String resourceTag;

    /**
     * 当前状态(1:修复0：未修复)
     */
    private Integer currentStatus;

    /**
     * 资源类型
     */
    private String resourceType;

    /**
     * 资源分类
     */
    private String resourceClass;


}
