package com.ocean.springcloud.oceaneureka.annotation.impl;

/**
 * @author 季超
 * @create 2018-11-23 14:58
 * @desc
 **/
public enum SwitchEnum {
    A("A"),
    B("B");

    private String switchName;

    SwitchEnum(String switchName) {
      this.switchName = switchName;
    }

    public String getSwitchName() {
        return switchName;
    }

    public void setSwitchName(String switchName) {
        this.switchName = switchName;
    }
}
