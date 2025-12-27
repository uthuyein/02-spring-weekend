package com.jdc.mkt.services;

import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class DataPushService {

	private List<String> list = List.of("Core Java", "Spring framework", "Angular", "React Native", "Python");

	@Async
	public void push(ResponseBodyEmitter emitter) {

		try {
			for (String course : list) {
				Thread.sleep(1000L);
				emitter.send(course);
			}

		} catch (Exception e) {
			emitter.completeWithError(e);
		}finally {
			emitter.complete();
		}

		// emitter.complete();
	}
	
	@Async
	public void pushSse(SseEmitter emitter) {

		try {
			for (String course : list) {
				Thread.sleep(1000L);
				emitter.send(course);
			}

		} catch (Exception e) {
			emitter.completeWithError(e);
		}finally {
			emitter.complete();
		}

		// emitter.complete();
	}

}
