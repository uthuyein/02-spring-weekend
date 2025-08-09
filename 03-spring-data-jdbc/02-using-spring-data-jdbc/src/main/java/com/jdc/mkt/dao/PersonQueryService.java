package com.jdc.mkt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonQueryService {

	final JdbcTemplate jdbc;
	
	public List<Person> selectWithResultSetExtractor(String sql){
		var list = jdbc.query(sql, rs ->{
			var persons = new ArrayList<Person>();
			
			while(rs.next()) {
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
