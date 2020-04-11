package com.ocean.springcloud.oceanmail.entity;

import lombok.*;

import java.util.List;

/**
 * @author: chao
 * @description:
 * @create: 2020-04-08 19:51
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailInhibition {
    /**
     * 策略名称
     */
    private String strategyName;
    /**
     * 发送时间
     */
    private String sendTime;
    /**
     * 标题
     */
    private String title;

    private List<EmailInhibition> emailInhibitionList;



}
