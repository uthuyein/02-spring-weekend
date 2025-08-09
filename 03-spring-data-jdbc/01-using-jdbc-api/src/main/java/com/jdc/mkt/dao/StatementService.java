package com.jdc.mkt.dao;

import static com.jdc.mkt.utils.Connector.getConnection;

import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

public non-sealed class StatementService implements DbServiceInt<Person> {

	@Override
	public int save(Person p) {
		try (var con = getConnection(); var stmt = con.createStatement()) {

			int row = stmt.executeUpdate("insert into person_tbl(name,age,day) values('%s',%d,'%s')"
					.formatted(p.getName(), p.getAge(), p.getDay().name()));
			
			
			return row;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public List<Person> select(Person p) {
		StringBuilder sb = new StringBuilder("select * from person_tbl p where 1=1");
		List<Person> persons = new ArrayList<Person>();
		
		if (null != p) {
			if (null != p.getName()) {
				sb.append(" and p.name like '%s'".formatted(p.getName().concat("%")));
			}
			
			if(null != p.getAge()) {
				sb.append(" and p.age = '%d'".formatted(p.getAge()));
			}
			if(null != p.getDay()) {
				sb.append(" and p.day = '%s'".formatted(p.getDay().name()));
			}
		}

		try (var con = getConnection(); var stmt = con.createStatement()) {

			var rs = stmt.executeQuery(sb.toString());
			
			while(rs.next()) {
				var person = new Person();
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
			    p.setDay(Days.valueOf(rs.getString("day")));
				
				persons.add(person);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return persons;
	}

}
