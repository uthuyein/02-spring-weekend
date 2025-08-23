package com.jdc.mkt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mkt.dto.Person;
import com.jdc.mkt.repo.PersonRepo;

@Service
public class PersonService {

	@Autowired
	PersonRepo service;
	
	public Person insert(Person p) {
		
		return service.save(p);
	}
}
