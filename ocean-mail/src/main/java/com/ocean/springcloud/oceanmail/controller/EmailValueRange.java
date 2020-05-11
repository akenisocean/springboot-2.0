package com.ocean.springcloud.oceanmail.controller;

import lombok.*;

/**
 * @author: chao
 * @description:
 * @create: 2020-04-24 21:18
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailValueRange {
    private String titleName;
    private String titleValue;
}
