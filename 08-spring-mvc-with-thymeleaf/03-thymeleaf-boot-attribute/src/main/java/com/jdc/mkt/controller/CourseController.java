package com.jdc.mkt.controller;

import java.io.FileInputStream;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.mkt.model.entity.Course;
import com.jdc.mkt.model.entity.Course.Level;
import com.jdc.mkt.model.input.CourseForm;
import com.jdc.mkt.model.repo.CourseRepo;
import com.jdc.mkt.model.services.CourseService;

@Controller
@RequestMapping("/")
public class CourseController {

	@Autowired
	private CourseRepo repo;
	@Autowired
	private CourseService service;

	@GetMapping({ "list", "/" })
	String index(ModelMap map) {
		map.put("courses", repo.findAll());
		return "courses/course-list";
	}
	
	@GetMapping("search")
	String search(@RequestParam Optional<Level> level,@RequestParam Optional<String> name,ModelMap map) {
		map.put("courses", service.search(level,name));
		
		return "courses/course-list";
	}

	@GetMapping("form")
	String edit() {
		return "courses/course-form";
	}

	@PostMapping("upload")
	String upload(@RequestPart("file") MultipartFile file) {
		if (null == file) {
			return "redirect:/list";
		}
		try{
			Workbook book = WorkbookFactory.create(file.getInputStream());
			Sheet sheet = book.getSheetAt(0);
			for (Row row : sheet) {
				var course = new Course();
				course.setName(row.getCell(0).toString());
				course.setLevel(Level.valueOf(row.getCell(1).toString()));
				course.setDuration(Double.parseDouble(row.getCell(2).toString()));
				course.setFees(Double.parseDouble(row.getCell(3).toString()));
				
				var oldCourse = repo.findByNameAndLevel(course.getName(), course.getLevel());
				if (null == oldCourse) {
					repo.save(course);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/list";
	}

	@PostMapping("course")
	String save(@Validated @ModelAttribute("courseForm") CourseForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "courses/course-form";
		}
		return "redirect:/list";
	}

	@ModelAttribute("levels")
	List<Level> levels() {
		return List.of(Level.values());
	}

	@ModelAttribute("courseForm")
	CourseForm courseForm() {
		return new CourseForm();
	}
}
