package com.jdc.mkt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan("com.jdc.mkt.dao")
@PropertySource({"classpath:/person_dml.properties","classpath:/datasource.properties"})
public class AppConfig {

	@Value("${sql.url}")
	String url;
	@Value("${sql.user}")
	String user;
	@Value("${sql.pass}")
	String pass;
	
	@Bean
	JdbcTemplate jdbcTemplate(DataSource datasource) {
		return new JdbcTemplate(datasource);
	}
	
	@Bean
	DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(user);
		config.setPassword(pass);
		return new HikariDataSource(config);
//		var ds = new MysqlConnectionPoolDataSource();
//		ds.setUrl(url);
//		ds.setUser(user);
//		ds.setPassword(pass);
//		return ds;
	}
}
