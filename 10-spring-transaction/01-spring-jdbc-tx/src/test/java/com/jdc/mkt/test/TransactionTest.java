package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.Application;
import com.jdc.mkt.services.PropagationService;

@SpringJUnitConfig(classes = Application.class)
public class TransactionTest {

	@Autowired
	private PropagationService service;
	
	@ParameterizedTest
	@CsvSource("2,member,Patrick")
	void test(int error,String type,String account ) {
		var list = service.save(error, type, account);
		assertNotNull(list);
	}
}
