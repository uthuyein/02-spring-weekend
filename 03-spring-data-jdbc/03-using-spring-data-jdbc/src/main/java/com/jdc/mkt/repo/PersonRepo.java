package com.jdc.mkt.repo;

import org.springframework.data.repository.CrudRepository;

import com.jdc.mkt.dto.Person;

public interface PersonRepo extends CrudRepository<Person, Integer> {

}
