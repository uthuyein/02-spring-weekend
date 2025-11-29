package com.jdc.mkt.model.input;

import com.jdc.mkt.model.entity.Course.Level;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CourseForm {

	private Integer id;
	@NotEmpty(message = "Type Course Name !")
	private String name;
	@NotNull(message = "Select Course Level !")
	private Level level;
	@NotNull(message = "Type Course Fees !")
	private Integer fees;
	@NotNull(message = "Type Course Duration With Months !")
	private Integer duration;
	
	private String description;
}
