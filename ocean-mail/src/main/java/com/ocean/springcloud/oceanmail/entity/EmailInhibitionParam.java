package com.ocean.springcloud.oceanmail.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author: chao
 * @description: 邮件告警信息
 * @create: 2020-04-08 19:55
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailInhibitionParam {
    private String tagName;
    private List<String> tagTitles;
    private TreeMap<String,List<String>> tagParams;
}
