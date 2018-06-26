package com.example.demo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {
    @Bean("dataSource")
    @Profile("pgsql")
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/my");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("sdk007");
        return driverManagerDataSource;
    }

    @Bean("dataSource")
    @Profile("h2")
    public DataSource DBMemory(){
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder=new EmbeddedDatabaseBuilder();
        embeddedDatabaseBuilder.addScript("db/schema.sql");
        embeddedDatabaseBuilder.addScript("db/data.sql");
        embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);

        return embeddedDatabaseBuilder.build();
    }
}
