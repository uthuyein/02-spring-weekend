package com.jdc.mkt.model.input;

import com.jdc.mkt.model.entity.Course;
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
	private Double fees;
	@NotNull(message = "Type Course Duration With Months !")
	private Double duration;
	
	private String description;

	public Course entity() {
		var c  = new Course();
		c.setName(name);
		c.setFees(fees);
		c.setDuration(duration);
		c.setLevel(level);
		c.setDescription(description);
		return c;
	}
}
