package com.jdc.mkt.controller;

import java.time.DayOfWeek;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamTypeHandlerController {

	@GetMapping("methodParam")
	String reqParamMethod(
		@RequestParam(name ="day" )	DayOfWeek dayOfWeek,
		@RequestParam(name="value",defaultValue = "5") int count,
		ModelMap map
			) {
		map.put("day", dayOfWeek);
		map.put("value", count);
		return "params/view1";
	}
}
