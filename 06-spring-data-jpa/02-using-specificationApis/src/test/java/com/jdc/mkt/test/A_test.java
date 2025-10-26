package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.entity.Customer;
import com.jdc.mkt.repo.CustomerRepo;

@SpringBootTest
public class A_test {

	@Autowired
	private CustomerRepo repo;
	
	@Test
	void test() {
		var c = new Customer();
		c.setName("ss");
		c.setEmail("dd@gmail.com");
		repo.save(c);
	}
}

