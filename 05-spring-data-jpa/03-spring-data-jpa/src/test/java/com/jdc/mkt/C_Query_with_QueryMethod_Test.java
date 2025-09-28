package com.jdc.mkt;

import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.entity.Customer.MemberType;
import com.jdc.mkt.entity.dto.SelectCNamePNameAndTotalQty;
import com.jdc.mkt.service.CustomerService;
import com.jdc.mkt.service.ProductService;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = ApplicationConfig.class)
public class C_Query_with_QueryMethod_Test {

	@Autowired
	CustomerService cService;
	
	@Autowired
	ProductService pService;
	
	@Test
	@Order(6)
	void findCNamePNameWithTotal() {
		List<SelectCNamePNameAndTotalQty> list = pService.findCNamePNameWithTotalQty();
		System.out.println(list);
	}
	@Test
	@Order(5)
	void findWithMemberType() {
		var list = cService.findWithMemberType(MemberType.Silver);
		assertEquals(1, list.size());
	}
	@Test
	@Order(4)
	void findByNameWithNamedQuery() {
		var list = cService.findByName("b");
		assertEquals(2, list.size());
	}
	
	@Test
	@Order(3)
	void findByContactWithSql() {
		var list = cService.findByContact("0911111111");
		assertEquals(2, list.size());
	}
	@Test
	@Order(2)
	void findByEmailWithJpql() {
		var list = cService.findByEmailWithJpql("alice.johnson@example.com");
		assertEquals(1, list.size());
	}
	@Test
	@Order(1)
	void findCustomerByContactEmailWithNamingRule() {
		var list = cService.findCustomerByContactEmail("alice.johnson@example.com");
		assertEquals(1, list.size());
	}
}
