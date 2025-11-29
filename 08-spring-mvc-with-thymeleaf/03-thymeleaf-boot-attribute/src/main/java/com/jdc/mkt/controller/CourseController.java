package com.jdc.mkt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.entity.Course.Level;
import com.jdc.mkt.model.input.CourseForm;

@Controller
@RequestMapping("/")
public class CourseController {

	@GetMapping({"list","/"})
	String index() {
		return "courses/course-list";
	}
	
	@GetMapping("form")
	String edit() {
		return "courses/course-form";
	}
	
	@PostMapping("course")
	String save(@Validated @ModelAttribute("courseForm") CourseForm form,BindingResult result) {
		if(result.hasErrors()) {
			return "courses/course-form";
		}
		return "redirect:/list";
	}
	
	@ModelAttribute("levels")
	List<Level> levels(){
		return List.of(Level.values());
	}
	
	@ModelAttribute("courseForm")
	CourseForm courseForm() {
		return new CourseForm();
	}
}
