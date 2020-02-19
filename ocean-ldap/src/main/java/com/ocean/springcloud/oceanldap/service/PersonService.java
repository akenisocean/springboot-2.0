package com.ocean.springcloud.oceanldap.service;

import com.ocean.common.api.Result;
import com.ocean.springcloud.oceanldap.entity.Person;
import com.ocean.springcloud.oceanldap.request.LoginRequest;

/**
 * @author: chao
 * @description:
 * @create: 2019-12-23 16:08
 */
public interface PersonService {
    /**
     * 登录
     *
     * @param request {@link LoginRequest}
     * @return {@link Result}
     */
    Result login(LoginRequest request);

    /**
     * 查询全部
     *
     * @return {@link Result}
     */
    Result listAllPerson();

    /**
     * 保存
     *
     * @param person {@link Person}
     */
    void save(Person person);

    /**
     * 删除
     *
     * @param person {@link Person}
     */
    void delete(Person person);
}
