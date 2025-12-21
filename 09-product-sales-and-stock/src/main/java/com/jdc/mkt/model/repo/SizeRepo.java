package com.jdc.mkt.model.repo;

import com.jdc.mkt.model.entity.Size;

public interface SizeRepo extends BaseRepo<Size, Integer>{

	Size findByName(String name);

}
