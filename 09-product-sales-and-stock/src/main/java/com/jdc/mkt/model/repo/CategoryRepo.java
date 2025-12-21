package com.jdc.mkt.model.repo;

import com.jdc.mkt.model.entity.Category;

public interface CategoryRepo extends BaseRepo<Category, Integer>{

	Category findByName(String name);

}
