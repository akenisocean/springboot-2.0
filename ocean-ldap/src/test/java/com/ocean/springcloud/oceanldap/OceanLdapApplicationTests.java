package com.ocean.springcloud.oceanldap;

import com.ocean.common.api.Result;
import com.ocean.springcloud.oceanldap.entity.Person;
import com.ocean.springcloud.oceanldap.request.LoginRequest;
import com.ocean.springcloud.oceanldap.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OceanLdapApplicationTests {
	@Test
	public void contextLoads() {
	}

	@Resource
	PersonService personService;

	/**
	 * 测试查询单个
	 */
	@Test
	public void loginTest() {
		LoginRequest loginRequest = LoginRequest.builder().username("wangwu").password("123456").build();
		Result login = personService.login(loginRequest);
	    log.info(login.toString());
	}

	/**
	 * 测试查询列表
	 */
	@Test
	public void listAllPersonTest() {
		Result result = personService.listAllPerson();
		log.info(result.toString());
	}

	/**
	 * 测试保存
	 */
	@Test
	public void saveTest() {
		Person person = new Person();

		person.setUid("zhaosi");

		person.setSurname("赵");
		person.setGivenName("四");
		person.setUserPassword("123456");

		// required field
		person.setPersonName("赵四");
		person.setUidNumber("666");
		person.setGidNumber("666");
		person.setHomeDirectory("/home/zhaosi");
		person.setLoginShell("/bin/bash");

		personService.save(person);
	}

	/**
	 * 测试删除
	 */
	@Test
	public void deleteTest() {
		Person person = new Person();
		person.setUid("zhaosi");

		personService.delete(person);
	}

}
