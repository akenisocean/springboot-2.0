package com.ocean.springclouid.druidmybatismultiple.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.ocean.springclouid.druidmybatismultiple.monitor.mapper",
        sqlSessionTemplateRef = "db1SqlSessionTemplate")
public class DataSourceMonitorConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.monitor")
    public DataSource monitorDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory monitorSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(monitorDataSource());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath*:mybatis/mapper/monitor/*.xml"));
//        bean.setTypeAliasesPackage("com.ocean.springclouid.druidmybatismultiple.monitor.entity");
        return bean.getObject();
    }

    /**
     * 配置事务管理器
     *
     * @return
     */
    @Bean
    public DataSourceTransactionManager monitorTransactionManager() {
        return new DataSourceTransactionManager(monitorDataSource());
    }

    @Bean
    public SqlSessionTemplate db1SqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(monitorSqlSessionFactory());
    }
}
