package com.jdc.dto;

import static com.jdc.utils.ShowLogger.*;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectLogger {
	
	public Object arroundAdvice(ProceedingJoinPoint joinpoint) {
		Object obj = null;
		
		try {
			showLog(joinpoint, "Before Execution With Arround");
			joinpoint.proceed();
			showLog(joinpoint, "After Execution With Arround");
			
		} catch (Throwable e) {
			showLog(joinpoint, "After Throwing With Arround");
			
			e.printStackTrace();
			
		}finally {
			showLog(joinpoint, "After Finally With Arround");			
		}
		
		return obj;
	}

	public void beforeExecution(JoinPoint joinpoint,int xx,int yy) {
		showLog(joinpoint, "BeforeExecution method");
		
	}
	
	public void afterExecution(JoinPoint joinpoint) {
		showLog(joinpoint, "AfterExecution method");
	}
	
	public void afterReturn(JoinPoint joinpoint) {
		showLog(joinpoint, "After Returning");
		
	}
	
	public void afterThrowing(JoinPoint joinpoint) {
		showLog(joinpoint, "After throwing exception");
	}
}
