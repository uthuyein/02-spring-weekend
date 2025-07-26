package com.jdc.interType;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import com.jdc.utils.ShowLogger;

@Component
public class WorkerAspect {

	void beforeWork(JoinPoint joinpoint) {
		ShowLogger.showLog(joinpoint, "Before Work");
	}
}
