package com.ocean.springclouid.druidmybatismultiple.controller;

import com.ocean.springclouid.druidmybatismultiple.cmdb.entity.VcenterResourceUsage;
import com.ocean.springclouid.druidmybatismultiple.cmdb.entity.VmwareUsage;
import com.ocean.springclouid.druidmybatismultiple.cmdb.entity.VmwareUsageCriteria;
import com.ocean.springclouid.druidmybatismultiple.cmdb.mapper.VcenterResourceUsageMapper;
import com.ocean.springclouid.druidmybatismultiple.cmdb.mapper.VmwareUsageMapper;
import com.ocean.springclouid.druidmybatismultiple.monitor.entity.User;
import com.ocean.springclouid.druidmybatismultiple.monitor.entity.Usermedia;
import com.ocean.springclouid.druidmybatismultiple.monitor.mapper.UserMapper;
import com.ocean.springclouid.druidmybatismultiple.monitor.mapper.UsermediaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author: chao
 * @description: 测试controller
 * @create: 2019-11-24 22:56
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    VcenterResourceUsageMapper vcenterResourceUsageMapper;

    @Autowired
    VmwareUsageMapper vmwareUsageMapper;

    @GetMapping("/testTransaction/{id}")
    @Transactional
    public void testTransaction(@PathVariable("id") Integer id) {
        VcenterResourceUsage vcenterResource = new VcenterResourceUsage();
        vcenterResource.setId(id);
        int i = vcenterResourceUsageMapper.insertSelective(vcenterResource);
        System.out.println(i);
        System.out.println("--------------------------------------");
        VmwareUsage record = new VmwareUsage();
        record.setId(id);
        int b = vmwareUsageMapper.insertSelective(record);
        System.out.println(b);
        if (id.equals(3)) {
            int ib = 1 / 0;
        }

    }

    @Autowired
    UserMapper userMapper;
    @Autowired
    UsermediaMapper usermediaMapper;

    @GetMapping("/testTransaction2/{id}")
    @Transactional
    public void testTransaction2(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        userMapper.insertSelective(user);
        Usermedia userMedia = new Usermedia();
        userMedia.setId(id);
        userMedia.setPeriod(UUID.randomUUID().toString());
        userMedia.setUserid(id);
        usermediaMapper.insertSelective(userMedia);
        if (id.equals(3)) {
            int ii = 1 / 0;
        }
    }


}
