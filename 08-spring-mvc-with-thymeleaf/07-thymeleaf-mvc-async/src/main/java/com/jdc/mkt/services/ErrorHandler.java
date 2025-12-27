package com.jdc.mkt.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ErrorHandler {

	@Async
	public void execute(String error, DeferredResult<ModelAndView> def) {
		var mv = new ModelAndView("async-result");
		try {
			if(null != error) {
				mv.getModelMap().put("title","Error Result");
				mv.getModelMap().put("message",error);
				System.out.println("Error ::: "+error);
			}
			Thread.sleep(2000L);
			def.setResult(mv);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
