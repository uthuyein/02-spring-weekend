package com.jdc.factory;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.dto.AppConfig;

@TestMethodOrder(OrderAnnotation.class)
//@SpringJUnitConfig(locations = "classpath:/context.xml")
@SpringJUnitConfig(classes = AppConfig.class)
public class JunitFactory {

	
}
