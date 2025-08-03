package com.jdc.mkt.dao;

import java.util.List;

import com.jdc.mkt.dto.Person;
import static com.jdc.mkt.utils.Connector.getConnection;

public class PrepareStatementService implements DbServiceInt<Person>{

	@Override
	public int save(Person p) {
		String query = "insert into person_tbl(name,age,day)values(?,?,?)";
		try(var con = getConnection();
				var stmt = con.prepareStatement(query)){
			
			stmt.setString(1, p.getName());
			stmt.setInt(2, p.getAge());
			stmt.setString(3, p.getDay().name());
			
			return stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Person> select(Person t) {
		String query = "";
		try(var con = getConnection();
				var stmt = con.prepareStatement(query)){
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
