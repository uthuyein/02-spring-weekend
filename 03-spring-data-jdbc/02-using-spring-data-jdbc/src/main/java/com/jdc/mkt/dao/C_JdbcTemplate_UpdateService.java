package com.jdc.mkt.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

@Service
public class C_JdbcTemplate_UpdateService {

	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	@Qualifier("insert") 
	PreparedStatementCreatorFactory factory;
	
	public int insertPersonWithParamsTypesAndValue(String sql,Person p) {
		return jdbc.update(sql, new Object[] {
				p.getName(),
				p.getAge(),
				p.getDay().name()
		}, new int[] {
				Types.VARCHAR,
				Types.INTEGER,
				Types.VARCHAR
		});
	}
	
	public int updatePersonWithObjectParams(String sql, String name,int age,Days days,int id) {
		return jdbc.update(sql,name,age,days.name(),id);
	}
	
	public int insertPersonWithCreatorAndKeyHolder(Person p) {
		PreparedStatementCreator creator = factory.newPreparedStatementCreator(List.of(p.getName(),
				p.getAge(),p.getDay().name()));
		
		factory.setReturnGeneratedKeys(true);
		var key = new GeneratedKeyHolder();			
		jdbc.update(creator, key);
		
		return  key.getKey().intValue();
	}
}
