package com.ocean.springcloud.oceanthirddemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: chao
 * @description:
 * @create: 2020-02-24 12:59
 */
public class LajiTest {
    public static void main(String[] args) {
        List<WarnConditionBean> warnConditionBeans = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            WarnConditionBean warnConditionBean = new WarnConditionBean();
            warnConditionBean.setTag(i+"");
            if (i > 3 && i < 8){
            warnConditionBean.setType("3");
            }else {
            warnConditionBean.setType(""+i);
            }
            warnConditionBean.setDecide("laji");
            warnConditionBean.setValueRange(100+i+"");
            warnConditionBeans.add(warnConditionBean);
        }
        Map<String, List<WarnConditionBean>> groupTypeCondition = warnConditionBeans.stream().collect(Collectors.groupingBy(WarnConditionBean::getType));
        groupTypeCondition.forEach((key,value)->{
            System.out.println("key:"+key+",value:"+value);
        });
    }
}
