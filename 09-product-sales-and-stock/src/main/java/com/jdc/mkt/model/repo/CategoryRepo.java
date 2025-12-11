package com.jdc.mkt.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.mkt.model.entity.Category;

public interface CategoryRepo extends JpaRepositoryImplementation<Category, Integer>{

}
