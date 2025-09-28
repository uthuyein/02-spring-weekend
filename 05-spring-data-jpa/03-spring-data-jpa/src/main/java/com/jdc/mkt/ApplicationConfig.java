package com.jdc.mkt;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@PropertySource("classpath:/mysqlDatasource.properties")
@ComponentScan(
		basePackages = {"com.jdc.mkt.service","com.jdc.mkt.repository"})
public class ApplicationConfig {

	@Bean
	DataSource datasource(
			@Value("${ds.url}") String url,
			@Value("${ds.user}") String user,
			@Value("${ds.pass}") String pass) {
		
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(user);
		config.setPassword(pass);
		return new HikariDataSource(config);
//		return new EmbeddedDatabaseBuilder()
//				.setType(EmbeddedDatabaseType.HSQL)
//				.build();
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
		var emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(ds);
		emf.setJpaPropertyMap(getPropertiesMap());
		emf.setPackagesToScan("com.jdc.mkt.entity");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return emf;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	Map<String, String> getPropertiesMap(){
		Map<String, String> map = new HashMap<>();
		map.put("hibernate.hbm2ddl.auto", "create-drop");
		map.put("hibernate.show_sql", "true");
		map.put("hibernate.format_sql", "true");
		return map;
	}
}
