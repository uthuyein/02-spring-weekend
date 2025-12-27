package com.jdc.mkt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>{

}
