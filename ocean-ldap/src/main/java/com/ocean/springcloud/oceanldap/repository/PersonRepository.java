package com.ocean.springcloud.oceanldap.repository;

import com.ocean.springcloud.oceanldap.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.naming.Name;

/**
 * @author: chao
 * @description:
 * @create: 2019-12-23 16:05
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Name> {
    /**
     * 根据用户名查找
     *
     * @param uid 用户名
     * @return  {@link Person}
     */
    Person findByUid(String uid);
}
