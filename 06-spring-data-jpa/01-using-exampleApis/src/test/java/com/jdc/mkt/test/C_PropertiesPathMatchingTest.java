package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import com.jdc.mkt.entity.Contact;
import com.jdc.mkt.entity.Customer;
import com.jdc.mkt.entity.Customer.MemberType;
import com.jdc.mkt.repo.ContactRepo;

@SpringBootTest
public class C_PropertiesPathMatchingTest {

	@Autowired
	private ContactRepo conRepo;

	@Test
	void usingMatcherConfigurer() {
		var cu = new Customer();
		cu.setName("a");
		cu.setMemberType(MemberType.Gold);

		var contact = new Contact();
		contact.setCustomer(cu);

		var matcher = ExampleMatcher.matching()
				.withIgnorePaths("id", "customer.id")

				.withMatcher("customer.name", m -> m.startsWith().ignoreCase())

				.withMatcher("customer.memberType", m -> m.exact());

		var example = Example.of(contact, matcher);

		var list = conRepo.findAll(example);
		System.out.println(list);
	}

	@Test
	@Disabled
	void usingGenericPropertyMatcher() {

		var cu = new Customer();
		cu.setName("b");
		cu.setMemberType(MemberType.Silver);

		var contact = new Contact();
		contact.setEmail("com");
		contact.setCustomer(cu);

		var matcher = ExampleMatcher.matching().withIgnorePaths("id", "customer.id")

				.withMatcher("email", GenericPropertyMatcher.of(StringMatcher.ENDING))

				.withMatcher("customer.name", GenericPropertyMatcher.of(StringMatcher.STARTING).ignoreCase())

				.withMatcher("customer.memberType", GenericPropertyMatcher.of(StringMatcher.EXACT));

		var example = Example.of(contact, matcher);

		var list = conRepo.findAll(example);
		System.out.println(list);
	}
}
