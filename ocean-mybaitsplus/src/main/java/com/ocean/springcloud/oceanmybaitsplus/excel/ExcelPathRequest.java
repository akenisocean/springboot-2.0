package com.ocean.springcloud.oceanmybaitsplus.excel;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: chao
 * @description:
 * @create: 2020-05-11 17:41
 */
@Data
public class ExcelPathRequest implements Serializable {
    private String excelPath;
}
