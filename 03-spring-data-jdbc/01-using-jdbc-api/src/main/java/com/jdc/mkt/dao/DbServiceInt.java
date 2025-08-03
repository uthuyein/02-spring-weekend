package com.jdc.mkt.dao;

import java.util.List;

public interface DbServiceInt<T> {

	int save(T t);
	List<T> select(T t);
	
}
