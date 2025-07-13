package com.jdc.dto;

import static com.jdc.utils.ShowLogger.showLog;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class AspectLogger {

	public void beforeExecution(JoinPoint joinpoint) {
		showLog(joinpoint, "BeforeExecution method");
	}
	
	public void afterExecution(JoinPoint joinpoint) {
		showLog(joinpoint, "AfterExecution method");
	}
}
