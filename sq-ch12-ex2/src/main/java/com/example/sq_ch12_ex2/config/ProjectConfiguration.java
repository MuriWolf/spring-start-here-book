package com.example.sq_ch12_ex2.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// this configuration is needed in just some cases, for example when more than one database in needed.

@Configuration
public class ProjectConfiguration {

    @Value("${custom.datasource.url}")
    private String dataSourceUrl;

    @Value("${custom.datasource.username}")
    private String dataSourceUsername;

    @Value("${custom.datasource.password}")
    private String dataSourcePassword;

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl(dataSourceUrl);
        dataSource.setUsername(dataSourceUsername);
        dataSource.setPassword(dataSourcePassword);

        return dataSource;
    }
}
