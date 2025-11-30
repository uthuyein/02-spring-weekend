package com.jdc.mkt.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.mkt.model.entity.Course;
import com.jdc.mkt.model.entity.Course.Level;

public interface CourseRepo extends JpaRepositoryImplementation<Course, Integer> {

	Course findByNameAndLevel(String name, Level level);

}
