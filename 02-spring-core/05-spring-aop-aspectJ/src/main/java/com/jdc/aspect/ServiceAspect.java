package com.jdc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.jdc.utils.ShowLogger;

@Component
@Aspect
public class ServiceAspect {

	@Pointcut("execution( * doSomething())")
	public void doSome() {
	}

	@Before("doSome()")
	public void before(JoinPoint joinpoint) {
		ShowLogger.showLog(joinpoint, "Before execution method !");
	}

	@After("doSome()")
	public void after(JoinPoint joinPoint) {
		ShowLogger.showLog(joinPoint, "After method");
	}

	@AfterReturning("doSome()")
	public void afterReturn(JoinPoint joinPoint) {
		ShowLogger.showLog(joinPoint, "After Return method!");
	}

	@AfterThrowing("doSome()")
	public void afterThrow(JoinPoint joinPoint) {
		ShowLogger.showLog(joinPoint, "After Throwing method!");
	}

	@Around("doSome()")
	public Object arround(ProceedingJoinPoint joinPoint) {
		
		Object obj = null;

		try {
			ShowLogger.showLog(joinPoint, "Before arround");
			obj = joinPoint.proceed();
			ShowLogger.showLog(joinPoint, "After arround");
			
		} catch (Throwable e) {
			
			ShowLogger.showLog(joinPoint, "After throwing arround");		
			e.printStackTrace();

		} finally {
			ShowLogger.showLog(joinPoint, "Finally arround");
			
		}
		return obj;
	}
}
