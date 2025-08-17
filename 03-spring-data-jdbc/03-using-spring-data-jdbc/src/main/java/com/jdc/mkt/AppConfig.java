package com.jdc.mkt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJdbcRepositories(basePackages = "com.jdc.mkt.dto.repo")
@ComponentScan(basePackages = "com.jdc.mkt.service")
@PropertySource({ "classpath:/p_statement.properties", "classpath:/s_statement.properties",
		"classpath:/datasource.properties" })
public class AppConfig {

	@Value("${sql.url}")
	String url;
	@Value("${sql.user}")
	String user;
	@Value("${sql.pass}")
	String pass;

	@Bean
	public DataSource dataSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(url);
		ds.setUsername(user);
		ds.setPassword(pass);
		return ds;
	}

	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
}
