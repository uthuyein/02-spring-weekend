package com.jdc.mkt.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

public class PersonRowMapper implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		var person = new Person();
		person.setName(rs.getString("name"));
		person.setAge(rs.getInt("age"));
		person.setDay(Days.valueOf(rs.getString("days")));
		return person;
	}

	

}
