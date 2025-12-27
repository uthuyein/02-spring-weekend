package com.jdc.mkt;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.jdc.mkt")
public class Application {

//	@Bean
//	JdbcTemplate jdbcTemplate(DataSource datasource) {
//		return new JdbcTemplate(datasource);
//	}
	
	@Bean
	DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/prepagateDb");
		config.setUsername("pUser");
		config.setPassword("pPass");
		return new HikariDataSource(config);

	}
	
	@Bean
	DataSourceTransactionManager transactionManager(DataSource dataSource) {
		var tx = new DataSourceTransactionManager(dataSource);
		return tx;
	}
}
