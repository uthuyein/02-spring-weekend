package com.jdc.mkt.dao;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jdc.mkt.dto.Person;

@Service
public class PersonService {

	@Autowired
	private JdbcTemplate jdbc;

	public int savePerson(Person p) {

		return jdbc.execute((Connection con) -> {
			var stmt = con.prepareStatement("insert into  person_tbl(name,age,day) values(?,?,?)");
			stmt.setString(1, p.getName());
			stmt.setInt(2, p.getAge());
			stmt.setString(3, p.getDay().name());

			return stmt.executeUpdate();
		});

	}
}
