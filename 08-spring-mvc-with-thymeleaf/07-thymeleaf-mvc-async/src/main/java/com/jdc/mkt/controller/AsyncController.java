package com.jdc.mkt.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/async")
public class AsyncController {

	@GetMapping("callable")
	Callable<String> callable(ModelMap map){
		map.put("title", "Callable Inteface");
		map.put("message", "Messages from callable interface !");
		return () -> "async-result";
		
	}
	
	@GetMapping("deferred")
	DeferredResult<String> deferred(@RequestParam(required = false) String error, ModelMap map){
		map.put("title", "DeferredResult Class");
		map.put("message", "Messages from deferred result class !");
		
		var def = new DeferredResult<String>(2000L);
		
		
		if(null != error) {
			def.setErrorResult(
			 new IllegalStateException(error));
		}
		
		def.onCompletion(() ->{
			System.out.println("Processing has been completed !");
		});
		
		def.onTimeout(() -> {
			System.out.println("Time Out !");
		});
		
		Executors.newSingleThreadExecutor().execute(() ->{
			try {
				Thread.sleep(3000L);
				System.out.println("Waiting time complete !");
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		try {
			Thread.sleep(3000L);
			def.setResult("async-result");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return def;
	}
	
	@ExceptionHandler
	ModelAndView loadException(IllegalStateException e) {
		var mv = new ModelAndView("async-result");
		mv.getModelMap().put("title","Error Result");
		mv.getModelMap().put("message", e.getMessage());
		return mv;
		
	}
}
