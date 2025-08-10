package com.jdc.mkt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages =  {
		"com.jdc.mkt.dao",
		"com.jdc.mkt.aspect",
		"com.jdc.mkt.factory"})
@PropertySource({
		"classpath:/p_statement.properties",
		"classpath:/s_statement.properties",
		"classpath:/datasource.properties"
	})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

	@Value("${sql.url}")
	String url;
	@Value("${sql.user}")
	String user;
	@Value("${sql.pass}")
	String pass;
	
	@Bean
	RowMapper<Person> rowMapper(){
		return (rs,num) -> {
			var p = new Person();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setAge(rs.getInt("age"));
			p.setDay(Days.valueOf(rs.getString("days")));
			return p;
		};
	}
	
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
