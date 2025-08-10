package com.jdc.mkt.factory;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

@Configuration
public class CreatorFactory {

	@Bean
	@Qualifier("byName")
	PreparedStatementCreatorFactory factoryForName(@Value("${p.select.by.name}") String sql) {
		return new PreparedStatementCreatorFactory(sql, new int[] {
				Types.VARCHAR
		});
	}
	
	@Bean
	@Qualifier("byAge")
	PreparedStatementCreatorFactory factoryForAge(@Value("${p.select.btw.age}") String sql) {
		return new PreparedStatementCreatorFactory(sql, new int[] {
				Types.INTEGER,
				Types.INTEGER
		});
	}
	
	@Bean
	@Qualifier("byDays")
	PreparedStatementCreatorFactory factoryForDay(@Value("${p.select.by.days}") String sql) {
		return new PreparedStatementCreatorFactory(sql, new int[] {
				Types.VARCHAR
		});
	}
}
