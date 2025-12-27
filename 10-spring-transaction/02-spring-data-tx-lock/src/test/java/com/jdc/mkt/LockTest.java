package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.services.AccountService;

@SpringBootTest
public class LockTest {

	@Autowired
	AccountService service;
	
	@Test
	void test() {
		var acc = service.find(1);
		assertNotNull(acc);
	}
}
