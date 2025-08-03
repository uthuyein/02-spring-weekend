package com.jdc.mkt.dao;

import java.util.List;

public sealed interface DbServiceInt<T> permits StatementService,PrepareStatementService {

	int save(T t);
	List<T> select(T t);
	
}
