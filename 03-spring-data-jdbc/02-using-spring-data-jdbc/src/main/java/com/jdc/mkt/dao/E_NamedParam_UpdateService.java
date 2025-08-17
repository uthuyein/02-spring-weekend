package com.jdc.mkt.dao;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.jdc.mkt.dto.Person;

@Service
public class E_NamedParam_UpdateService {

	@Autowired
	private NamedParameterJdbcTemplate nameParams;
	
	//work with record class
	public List<com.jdc.mkt.dto.rec.Person> selectWithDataClassRowMapper(String sql){
		var bean = new DataClassRowMapper<com.jdc.mkt.dto.rec.Person>(com.jdc.mkt.dto.rec.Person.class);
		return nameParams.query(sql, bean);
	}
	
	//work with pojo class
	public List<Person> selectWithBeanPropertyRowMapper(String sql){
		var bean = new BeanPropertyRowMapper<Person>(Person.class);
		return nameParams.query(sql, bean);
	}
	
	public int updateWithExecute(String sql,String name,int age,int id) {
		var map = new HashMap<String, Object>();
		map.put("p_name",name );
		map.put("p_age", age);
		map.put("p_id", id);
		return nameParams.execute(sql,
				new MapSqlParameterSource(map),
				PreparedStatement::executeUpdate);
	}
	
	public int insertWithMap(String sql,Person p) {
		var map = new HashMap<String, Object>();
		map.put("n", p.getName());
		map.put("a", p.getAge());
		map.put("d", p.getDay().name());
			
		return nameParams.update(sql, map);
	}
}
