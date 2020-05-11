package com.ocean.springcloud.oceandemo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: chao
 * @description:
 * @create: 2020-04-20 15:44
 */
@Data
@ApiModel("转换接受")
public class ReceiveConvert {
    @JsonProperty("source")
    @ApiModelProperty(value = "来自",name = "source")
    private String from;
}
