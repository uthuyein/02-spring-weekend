package com.jdc.mkt.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.stereotype.Service;

import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

@Service
public class PersonExecuteService {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Value("${p.prep.insert}")
	private String insert;
	@Value("${p.prep.select}")
	private String select;
	@Value("${p.prep.delete}")
	private String delete;
	@Value("${p.stmt.update}")
	private String update;
	
	public List<Person> selectPersonWithPerparedStatementCreator(int id){
		
		var factory = new PreparedStatementCreatorFactory(select,new int[] {
			Types.INTEGER	
		});
		var creator = factory.newPreparedStatementCreator(List.of(id));
		var list = jdbc.execute(creator, (PreparedStatement stmt) ->{
			
			var persons = new ArrayList<Person>();
			var rs = stmt.executeQuery();
			
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
	
	public List<Person> selectPersonWithCallableStatement(){
		var list = jdbc.execute("select * from person_tbl",(CallableStatement stmt) ->{
			var persons = new ArrayList<Person>();
			var rs = stmt.executeQuery();
			
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
	
	public int deletePersonWithPrepStement(int id) {
		return jdbc.execute(delete, (PreparedStatement stmt) ->{
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		});
	}
	
	public int updatePersonWithStatement(Person p) {
		return jdbc.execute((Statement stmt) ->
		stmt.executeUpdate(
	    update.formatted(p.getName(),p.getAge(),p.getId())));
	}

	public int savePersonWithConnection(Person p) {

		return jdbc.execute((Connection con) -> {
			var stmt = con.prepareStatement(insert);
			stmt.setString(1, p.getName());
			stmt.setInt(2, p.getAge());
			stmt.setString(3, p.getDay().name());

			return stmt.executeUpdate();
		});

	}
}
