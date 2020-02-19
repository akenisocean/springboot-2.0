package com.ocean.springclouid.druidmybatismultiple;

import com.ocean.springclouid.druidmybatismultiple.cmdb.entity.VcenterResourceUsage;
import com.ocean.springclouid.druidmybatismultiple.cmdb.entity.VcenterResourceUsageCriteria;
import com.ocean.springclouid.druidmybatismultiple.cmdb.entity.VmwareUsage;
import com.ocean.springclouid.druidmybatismultiple.cmdb.entity.VmwareUsageCriteria;
import com.ocean.springclouid.druidmybatismultiple.cmdb.mapper.VcenterResourceUsageMapper;
import com.ocean.springclouid.druidmybatismultiple.cmdb.mapper.VmwareUsageMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidMybatisMultipleApplicationTests {

    @Autowired
    VcenterResourceUsageMapper vcenterResourceUsageMapper;

    @Autowired
    VmwareUsageMapper vmwareUsageMapper;

    @Test
    public void contextLoads() {
        transactionalTest();
    }

    @Transactional
    public void transactionalTest() {
        VcenterResourceUsage vcenterResource = new VcenterResourceUsage();
        vcenterResource.setId(4);
        int i = vcenterResourceUsageMapper.insertSelective(vcenterResource);
        System.out.println(i);
        System.out.println("--------------------------------------");
        VmwareUsageCriteria vcenterExample = new VmwareUsageCriteria();
        List<VmwareUsage> vmwareUsages = vmwareUsageMapper.selectByExample(vcenterExample);
        System.out.println(vmwareUsages.size());
        int ib = 1 / 0;
    }

}
