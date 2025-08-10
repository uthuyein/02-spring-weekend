package com.jdc.mkt.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonQueryService {

	final JdbcTemplate jdbc;
	
	@Autowired
	RowMapper<Person> rowMapper;
	
	@Autowired
	PreparedStatementCreatorFactory nameFactory;
	
	public List<Person> selectWithPreparedStatementCreator(String name){		
		var creator = nameFactory.newPreparedStatementCreator(List.of(name));		
		return jdbc.query(creator, rowMapper);
	}
	
	public List<Person> selectWithRowMapper(String sql){
		return jdbc.query(sql, rowMapper);
	}

	public List<Person> selectWithRowCallbackHandler(String sql) {
		
		var list = new ArrayList<Person>();
		
		jdbc.query(sql, r -> {
			var p = new Person();
			p.setId(r.getInt("id"));
			p.setName(r.getString("name"));
			p.setAge(r.getInt("age"));
			p.setDay(Days.valueOf(r.getString("days")));
			list.add(p);
		});

		return list;
	}

	public List<Person> selectWithResultSetExtractor(String sql) {
		var list = jdbc.query(sql, rs -> {
			
			var persons = new ArrayList<Person>();

			while (rs.next()) {
				var p = new Person();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setDay(Days.valueOf(rs.getString("days")));
				persons.add(p);
			}
			return persons;
		});
		return list;
	}
}
