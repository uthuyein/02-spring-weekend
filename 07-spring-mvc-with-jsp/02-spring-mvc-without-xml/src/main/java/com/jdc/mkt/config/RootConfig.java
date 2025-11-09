package com.jdc.mkt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = "com.jdc.mkt.model.repo")
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.jdc.mkt.model.service"})
public class RootConfig {

	@Bean
	DataSource dataSource() {
		var ds = new BoneCPConfig();
		ds.setJdbcUrl("jdbc:postgresql://localhost:5432/testDb");
		ds.setUsername("testUser");
		ds.setPassword("testPass");
		return new BoneCPDataSource(ds);
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
		var bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(ds);
		bean.setJpaPropertyMap(jpaProperties());
		bean.setPackagesToScan("com.jdc.mkt.model.entity");
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return bean;
	}

	private Map<String, String> jpaProperties() {
		var map = new HashMap<String, String>();
		map.put("hibernate.hbm2ddl.auto", "create-drop");
		map.put("hibernate.show_sql", "true");
		map.put("hibernate.format_sql", "true");
		return map;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
