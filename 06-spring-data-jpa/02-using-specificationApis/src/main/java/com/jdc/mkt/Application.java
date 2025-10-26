package com.jdc.mkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jdc.mkt.repo.BaseRepoImpl;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = BaseRepoImpl.class)
@ComponentScan(basePackages = {"com.jdc.mkt.service"," com.jdc.mkt.repo"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
