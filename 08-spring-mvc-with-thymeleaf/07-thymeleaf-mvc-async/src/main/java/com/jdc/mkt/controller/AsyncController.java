package com.jdc.mkt.controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import com.jdc.mkt.services.ErrorHandler;

@Controller
@RequestMapping("/async")
public class AsyncController {
	
	@Autowired
	private ErrorHandler handler;

	@GetMapping("callable")
	Callable<String> callable(ModelMap map){
		
		map.put("title", "Callable Inteface");
		map.put("message", "Messages from callable interface !");
		return () -> "async-result";
		
	}
	
	@GetMapping("deferred")
	DeferredResult<ModelAndView> deferred(@RequestParam(required = false) String error, ModelMap map){
		map.put("title", "DeferredResult Class");
		map.put("message", "Messages from deferred result class !");
		
		var def = new DeferredResult<ModelAndView>(5000L);
		
		def.onCompletion(() ->{
			System.out.println("Processing has been completed !");
		});
		
		def.onTimeout(() -> {
			map.put("message", "Time out Exception !");
			def.setResult(new ModelAndView("async-result"));
		});
		
		handler.execute(error, def);
		
		//		Executors.newSingleThreadExecutor().execute(() ->{
//			try {
//				if(null != error) {
//					map.put("title","Error Result");
//					map.put("message",error);
//					System.out.println("Error ::: "+error);
//				}
//				Thread.sleep(2000L);
//				def.setResult("async-result");
//				
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		});
		
		return def;
	}
	
//	@ExceptionHandler
//	ModelAndView loadException(IllegalStateException e) {
//		var mv = new ModelAndView("async-result");
//		mv.getModelMap().put("title","Error Result");
//		mv.getModelMap().put("message", e.getMessage());
//		return mv;
//		
//	}
}
