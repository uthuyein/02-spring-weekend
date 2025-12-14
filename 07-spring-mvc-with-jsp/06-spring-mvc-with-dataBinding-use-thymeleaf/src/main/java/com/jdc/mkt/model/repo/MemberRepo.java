package com.jdc.mkt.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.model.entity.Member;

public interface MemberRepo extends JpaRepository<Member, Integer>{

	Member findFirstByName(String name);

	
}
