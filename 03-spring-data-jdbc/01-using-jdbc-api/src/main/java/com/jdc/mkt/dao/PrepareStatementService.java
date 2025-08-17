package com.jdc.mkt.dao;

import static com.jdc.mkt.utils.Connector.getConnection;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

public final class PrepareStatementService implements DbServiceInt<Person> {

	@Override
	public int save(Person p) {
		String query = "insert into person_tbl(name,age,day)values(?,?,?)";
		try (var con = getConnection(); var stmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, p.getName());
			stmt.setInt(2, p.getAge());
			stmt.setString(3, p.getDay().name());
			
			stmt.executeUpdate();
			
			var rs = stmt.getGeneratedKeys();
			while(rs.next()) {
				return rs.getInt("id");
			}
			return 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Person> select(Person p) {
		StringBuilder sb = new StringBuilder("select * from person_tbl p where 1=1");
		List<Person> persons = new ArrayList<Person>();
		List<Object> temp = new ArrayList<Object>();

		if (null != p) {
			if (null != p.getName()) {
				sb.append(" and p.name like lower(?)");
				temp.add(p.getName().concat("%").toLowerCase());
			}

			if (null != p.getAge()) {
				sb.append(" and p.age = ?");
				temp.add(p.getAge());
			}
			if (null != p.getDay()) {
				sb.append(" and p.day = ?");
				temp.add(p.getDay().name());
			}
		}

		try (var con = getConnection(); 
				var stmt = con.prepareStatement(sb.toString())) {
			
			for(int i = 0 ;i < temp.size() ; i++) {
				stmt.setObject(i+1, temp.get(i));
			}
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				var person = new Person();
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setDay(Days.valueOf(rs.getString("day")));
				persons.add(person);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return persons;
	}

}
