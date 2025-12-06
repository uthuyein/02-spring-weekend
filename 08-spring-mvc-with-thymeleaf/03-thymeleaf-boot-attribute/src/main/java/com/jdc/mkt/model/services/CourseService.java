package com.jdc.mkt.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.mkt.model.entity.Course;
import com.jdc.mkt.model.entity.Course.Level;
import com.jdc.mkt.model.repo.CourseRepo;

@Service
public class CourseService {

	@Autowired
	private CourseRepo repo;

	@SuppressWarnings("removal")
	public List<Course> search(Optional<Level> level, Optional<String> name) {

		Specification<Course> whichLevel = level.isEmpty() ? Specification.where(null)
				: (root, query, cb) -> cb.equal(root.get("level"), level.get());

		Specification<Course> whichName = name.isEmpty() ? Specification.where(null)
				: (root, query, cb) -> cb.like(cb.lower( root.get("name")), name.get().toLowerCase().concat("%"));

		return repo.findAll(whichLevel.and(whichName));
	}

	public Course save(Course entity) {
		return repo.save(entity);
	}

}
