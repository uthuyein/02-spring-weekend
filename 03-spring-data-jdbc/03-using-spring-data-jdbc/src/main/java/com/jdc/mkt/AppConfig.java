package com.jdc.mkt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "com.jdc.mkt.repo")
@ComponentScan(basePackages = "com.jdc.mkt.service")
@PropertySource({"classpath:/datasource.properties" })
public class AppConfig {

    @Value("${sql.url}")
    String url;
    @Value("${sql.user}")
    String user;
    @Value("${sql.pass}")
    String pass;
    
    public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

    @Bean
    DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(pass);
        return ds;
    }
}

