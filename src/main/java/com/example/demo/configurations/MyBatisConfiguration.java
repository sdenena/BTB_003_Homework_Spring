package com.example.demo.configurations;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.example.demo.repositories")
public class MyBatisConfiguration {
    private DataSource dataSource;
    public MyBatisConfiguration(@Qualifier("dataSource") DataSource dataSource){
        this.dataSource=dataSource;
    }
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource);
    }
}
