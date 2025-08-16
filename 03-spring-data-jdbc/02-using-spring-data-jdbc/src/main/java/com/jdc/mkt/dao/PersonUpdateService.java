package com.jdc.mkt.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import com.jdc.mkt.dto.Person;

@Service
public class PersonUpdateService {

	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	@Qualifier("insert") 
	PreparedStatementCreatorFactory factory;
	
	public int insertPersonWithCreatorAndKeyHolder(Person p) {
		PreparedStatementCreator creator = factory.newPreparedStatementCreator(List.of(p.getName(),p.getAge(),p.getDay().name()));
		
		factory.setReturnGeneratedKeys(true);
		var key = new GeneratedKeyHolder();			
		jdbc.update(creator, key);
		
		return  key.getKey().intValue();
	}
}
