package com.jdc.mkt.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.model.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
