package com.jdc.interType;

import org.springframework.stereotype.Component;

import com.jdc.utils.ShowLogger;

@Component
public class Worker {

	public void doWork() {
		ShowLogger.output("Do work from worker !");
	}
	public void doWork(String message) {
		ShowLogger.output("Do work from worker !");
		ShowLogger.output(message);
	}
}
