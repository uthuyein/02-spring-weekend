package com.jdc.mkt.repo;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CategoryRepo {

	private SimpleJdbcInsert insert;
	
	public CategoryRepo(DataSource datasource) {
		insert = new SimpleJdbcInsert(datasource);
		insert.setTableName("category_tbl");
		insert.setGeneratedKeyName("id");
		insert.setColumnNames(List.of("name"));
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int create(String name){		
		return insert.executeAndReturnKey(Map.of("name",name)).intValue();
	}
}
