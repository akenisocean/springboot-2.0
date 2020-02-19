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
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.ocean.springclouid.druidmybatismultiple.cmdb.mapper",
        sqlSessionTemplateRef = "dbCacSqlSessionTemplate")
public class DataSourceCmdbConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.cmdb")
    @Primary
    public DataSource dbCacDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public SqlSessionFactory dbCacSqlSessionFactory(@Qualifier("dbCacDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.
                getResources("classpath:/mybatis/mapper/cmdb/*.xml"));
//        bean.setTypeAliasesPackage("com.ocean.springclouid.druidmybatismultiple.cmdb.entity");
        return bean.getObject();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager dbCacTransactionManager(@Qualifier("dbCacDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionTemplate dbCacSqlSessionTemplate(@Qualifier("dbCacSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
