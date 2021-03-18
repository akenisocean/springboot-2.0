package com.ocean.springcloud.oceansecurity.config;

import com.ocean.springcloud.oceansecurity.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * @author happygiraffe
 * @description security配置
 * @create 2020-05-06 23:06
 */
@EnableWebSecurity
@Configurable
/**
 * 开启方法权限验证
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    MyUserDetailService myUserDetailService;
    @Resource
    MyPasswordEncoder myPasswordEncoder;



    @Override
    public void configure(WebSecurity web) {
        //不拦截静态资源,所有用户均可访问的资源
        web.ignoring().antMatchers(
                "/css/**",
                "/js/**",
                "/images/**",
                "/layui/**"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 对/不惊醒权限验证操作
        http.authorizeRequests().antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().permitAll()
                .and()
                .formLogin();
        // csrf关闭
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 自定义自己的userService,以及对应的密码验证器
        auth.userDetailsService(myUserDetailService).passwordEncoder(myPasswordEncoder);

        /**
         * 使用默认的内存用户管理操作
         */
        // 指定当前admin用户的角色为ADMIN
//        auth.inMemoryAuthentication().passwordEncoder(myPasswordEncoder).withUser("admin").password("123456").roles("ADMIN");
        // 授予user角色的权限
//        auth.inMemoryAuthentication().passwordEncoder(myPasswordEncoder).withUser("demo").password("123456").roles("USER");
    }

    /**
     * 密码加密算法
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();

    }
}
