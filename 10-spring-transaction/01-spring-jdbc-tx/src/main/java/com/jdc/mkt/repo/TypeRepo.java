package com.jdc.mkt.repo;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TypeRepo {

	private SimpleJdbcInsert insert;
	
	public TypeRepo(DataSource dataSource) {
		insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("type_tbl");
		insert.setGeneratedKeyName("id");
		insert.setColumnNames(List.of("name"));
	}
	
	@Transactional(propagation = Propagation.MANDATORY,isolation = Isolation.READ_COMMITTED)
	public int save(String name){
		return insert.executeAndReturnKey(Map.of("name",name)).intValue();
	}
}
