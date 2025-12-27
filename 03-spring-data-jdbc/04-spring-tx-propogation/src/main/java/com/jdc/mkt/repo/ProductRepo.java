package com.jdc.mkt.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepo {
	
private SimpleJdbcInsert insert;
	

public ProductRepo(DataSource datasource) {
	insert = new SimpleJdbcInsert(datasource);
	insert.setTableName("product_tbl");
	insert.setGeneratedKeyName("id");
	insert.setColumnNames(List.of("name","cat_id"));
}


@Transactional(propagation = Propagation.SUPPORTS)
public List<Integer> create(int catId,String ...names){
		List<Integer> list = new ArrayList<Integer>();
		
		for(var name : names) {
			var id = insert.executeAndReturnKey(Map.of(
					"cat_id",catId,
					"name",name
					)).intValue();
			list.add(id);
		}
		
		return list;
	}
}
