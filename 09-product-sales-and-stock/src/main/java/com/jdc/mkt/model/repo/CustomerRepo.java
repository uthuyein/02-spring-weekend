package com.jdc.mkt.model.repo;

import com.jdc.mkt.model.entity.Customer;

public interface CustomerRepo extends BaseRepo<Customer, Integer>{

	Customer findByName(String name);

}
