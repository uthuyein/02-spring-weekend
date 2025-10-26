package com.jdc.mkt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
