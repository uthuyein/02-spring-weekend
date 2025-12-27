package com.jdc.mkt.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AccountRepo {

	private SimpleJdbcInsert insert;
	
	public AccountRepo(DataSource dataSource) {
		insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("account_tbl");
		insert.setGeneratedKeyName("id");
		insert.setColumnNames(List.of("type_id","name"));
	}
	
	@Transactional
	public List<Integer> save(int typeId,String... names){
		var list = new ArrayList<Integer>();
		
		for(String name :names) {
			var val = insert.executeAndReturnKey(Map.of(
					"type_id",typeId,
					"name",name)).intValue();
			list.add(val);
		}
		return list;
	}
}
