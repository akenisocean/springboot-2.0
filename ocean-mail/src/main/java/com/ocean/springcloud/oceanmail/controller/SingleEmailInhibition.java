package com.ocean.springcloud.oceanmail.controller;

import lombok.*;

import java.util.List;

/**
 * @author: chao
 * @description:
 * @create: 2020-04-24 21:09
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SingleEmailInhibition {
    private String title;
    private List<EmailValueRange> valueRange;
}
