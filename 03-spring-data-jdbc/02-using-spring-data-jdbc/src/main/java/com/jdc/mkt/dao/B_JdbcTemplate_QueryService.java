package com.jdc.mkt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class B_JdbcTemplate_QueryService {

	final JdbcTemplate jdbc;
	
	@Autowired
	RowMapper<Person> rowMapper;
	
	@Autowired
	@Qualifier("byName")
	PreparedStatementCreatorFactory nameFactory;
	
	@Autowired
	@Qualifier("byAge")
	PreparedStatementCreatorFactory ageFactory;
	
	
	
	public Integer selectCountByNameLike(String sql,String name) {
		return jdbc.queryForObject(sql, Integer.class,name);
	}
	
	public List<Map<String, Object>> selectWithQueryForListByNameLike(String sql,String name){
		return jdbc.queryForList(sql,name);
	}
	
	public List<String> selectWithQueryForListByName(String sql,String name){
		return  jdbc.queryForList(sql,String.class,name);
	}
	public List<Person> selectWithRowMapper(String sql){
		return jdbc.query(sql, new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public List<Person> selectWithPreparedStatementCreatorByAge(int first,int last){		
		var creator = ageFactory.newPreparedStatementCreator(List.of(first,last));		
		var list = new ArrayList<Person>();
		jdbc.query(creator, r -> {
			var p = new Person();
			p.setId(r.getInt("id"));
			p.setName(r.getString("name"));
			p.setAge(r.getInt("age"));
			p.setDay(Days.valueOf(r.getString("days")));
			list.add(p);
		});
		return list;
	}
	
	public List<Person> selectWithPreparedStatementCreatorByName(String name){		
		var creator = nameFactory.newPreparedStatementCreator(List.of(name));		
		return jdbc.query(creator, rowMapper);
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
