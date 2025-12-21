package com.jdc.mkt.model.repo;

import com.jdc.mkt.model.entity.Supplier;

public interface SupplierRepo extends BaseRepo<Supplier, Integer>{

	Supplier findByName(String name);

}
