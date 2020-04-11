package com.ocean.springcloud.oceanmail;

import lombok.Data;

import java.util.List;

/**
 * @Author Bin Deng
 * @Date:2020/4/9 11:08
 */
@Data
public class AlarmPlatformRequest {
    private Integer parentType;
    private Integer currentType;
    private String currentDicide;
    private String parantDecide;
    private List<String> valueRange;
}
