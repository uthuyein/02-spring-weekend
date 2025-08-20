package com.jdc.mkt.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import com.jdc.mkt.dto.Person;

@Service
public class D_SimpleJdbcInsert_UpdateService {

	@Autowired
	private SimpleJdbcInsert insert;
	@Autowired
	@Qualifier("insert")
	private PreparedStatementCreatorFactory factory;
	
	
	//Use for insert query
	public int insertWithSimpleJdbcInsert(Person p) {
		var map = new HashMap<String, Object>();
		map.put("name", p.getName());
		map.put("age", p.getAge());
		map.put("days", p.getDay().name());
		return insert.executeAndReturnKey(map).intValue();
	}
	public int insertWithJdbcTemplate(String sql, Person p) {
		var creator = factory.newPreparedStatementCreator(List.of(p.getName(),p.getAge(),p.getDay().name()));
		factory.setReturnGeneratedKeys(true);
		var key = new GeneratedKeyHolder();
		insert.getJdbcTemplate().update(creator, key);
		return key.getKey().intValue();
	}
}
