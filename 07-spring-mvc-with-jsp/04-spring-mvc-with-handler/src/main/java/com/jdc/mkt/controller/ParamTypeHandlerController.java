package com.jdc.mkt.controller;

import java.time.DayOfWeek;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.mkt.model.dto.JavaBean;

@Controller
@RequestMapping("/params")
public class ParamTypeHandlerController {
	
	@GetMapping
	//@RequestMapping(method = RequestMethod.GET,path="/")
	String index() {
		return "params/param";
	}
	
	@GetMapping("path/{pMessage}")
	String formPath(@PathVariable(name = "pMessage") String pMessage,ModelMap map) {
		map.put("pMessage", pMessage);
		return "params/pathParam";
	}
	
	@GetMapping("form/get")
	String formGetParam(@RequestParam(name = "type",required = false) String type,JavaBean bean, ModelMap map) {
		map.put("type", type);
		map.put("message",bean.getMessage() );
		map.put("value", bean.getValue());
		return "params/formParam";
	}
	
	@PostMapping("form/post")
	String formPostParam(JavaBean bean,ModelMap map) {
		map.put("message",bean.getMessage() );
		map.put("value", bean.getValue());
		return "params/formParam";
	}

	@GetMapping("methodParam")
	String reqParamMethod(
		@RequestParam(name ="day" )	DayOfWeek dayOfWeek,
		@RequestParam(name="value",defaultValue = "5") int count,
		ModelMap map
			) {
		map.put("day", dayOfWeek);
		map.put("value", count);
		return "params/requestParam";
	}
}
