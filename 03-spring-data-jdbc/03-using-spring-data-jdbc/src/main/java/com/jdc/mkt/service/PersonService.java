package com.jdc.mkt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mkt.dto.Person;

@Service
public class PersonService {

	@Autowired
	PersonService service;
	
	public void insert(Person p) {
		service.insert(p);
	}
}
