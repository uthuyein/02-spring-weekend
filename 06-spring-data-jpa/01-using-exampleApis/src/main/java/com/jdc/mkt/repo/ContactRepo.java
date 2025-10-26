package com.jdc.mkt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer>{

}
