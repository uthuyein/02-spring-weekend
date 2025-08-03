package com.jdc.mkt.dao;

import static com.jdc.mkt.utils.Connector.getConnection;

import java.util.List;

import com.jdc.mkt.dto.Person;

public class StatementService implements DbServiceInt<Person> {

	@Override
	public int save(Person p) {
		try (var con = getConnection(); 
			var stmt = con.createStatement()) {

			int row = stmt.executeUpdate("insert into person_tbl(name,age,day) values('%s',%d,'%s')"
					.formatted(p.getName(),p.getAge(), p.getDay().name()));

			return row;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public List<Person> select(Person t) {
		return null;
	}

}
