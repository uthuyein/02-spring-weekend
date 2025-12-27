package com.jdc.mkt.controller;

import java.util.List;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.jdc.mkt.services.DataPushService;

@Controller
@RequestMapping("response")
public class ResponseController {

	@Autowired
	private DataPushService service;
	
	private List<String> list = List.of("Core Java", "Spring framework", "Angular", "React Native", "Python");

	
	@GetMapping
	String index() {
		return "async-response";
	}
	
	@GetMapping("stream")
	ResponseBodyEmitter emitter() {
		var emit = new ResponseBodyEmitter();
		
		Executors.newSingleThreadExecutor().execute(() -> {
			try {
				for (String course : list) {
					Thread.sleep(1000L);
					emit.send(course);
				}

			} catch (Exception e) {
				emit.completeWithError(e);
			}finally {
				emit.complete();
			}
		});
		
		//service.push(emit);
		
		return emit;
	}
	
	@GetMapping("sse")
	SseEmitter sse() {
		var sse = new SseEmitter();
		service.pushSse(sse);
		return sse;
	}
}
