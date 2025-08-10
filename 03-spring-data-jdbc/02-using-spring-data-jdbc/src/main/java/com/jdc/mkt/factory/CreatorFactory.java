package com.jdc.mkt.factory;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

@Configuration
public class CreatorFactory {

	@Bean
	PreparedStatementCreatorFactory factoryForName(@Value("${p.select.by.name}") String sql) {
		return new PreparedStatementCreatorFactory(sql, new int[] {
				Types.VARCHAR
		});
	}
}
