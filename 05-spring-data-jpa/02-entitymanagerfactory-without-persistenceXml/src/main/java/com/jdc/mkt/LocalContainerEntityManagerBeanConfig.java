package com.jdc.mkt;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages = {"com.jdc.mkt.entity","com.jdc.mkt.service"})
@EnableTransactionManagement
public class LocalContainerEntityManagerBeanConfig {
	
	@Bean
	DataSource dataSource() {
		var config = new BoneCPConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/testDb");
		config.setUsername("root");
		config.setPassword("admin");
		return new BoneCPDataSource(config);
		
	}

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource) {
		var bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setPackagesToScan("com.jdc.mkt.entity");
		bean.setJpaProperties(jpaProperties());
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return bean;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	private Properties jpaProperties() {
		var prop = new Properties();
		//prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		prop.put("jakarta.persistence.schema-generation.database.action", "drop-and-create");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.format_sql", "true");
		return prop;
	}

	
}
