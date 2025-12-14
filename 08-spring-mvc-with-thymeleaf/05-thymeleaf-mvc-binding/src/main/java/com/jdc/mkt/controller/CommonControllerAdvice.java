package com.jdc.mkt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import com.jdc.mkt.binding.MemberConverter;
import com.jdc.mkt.binding.MemberFormatter;

@ControllerAdvice
public class CommonControllerAdvice {

	@Autowired
	MemberConverter converter;
	@Autowired
	MemberFormatter formatter;
	
	@InitBinder
	void converterConfig(WebDataBinder binder) {
		binder.addCustomFormatter(formatter);
//		
//		if(binder.getConversionService() instanceof ConfigurableConversionService registery) {
//			registery.addConverter(converter);
//		}
		
	}
}
