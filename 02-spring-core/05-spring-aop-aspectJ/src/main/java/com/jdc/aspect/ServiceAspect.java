package com.jdc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.jdc.utils.ShowLogger;

@Component
@Aspect
public class ServiceAspect {

	@Pointcut("this(com.jdc.dto.MyService)")
	public void doSome() {
	}
	
	@Before(argNames = "mess",
			value = "execution(* setData(..)) and args(mess,..)")
	public void before(JoinPoint joinpoint, String mes) {
		ShowLogger.showLog(joinpoint, "Before execution method !");
		ShowLogger.output("Args values :%s".formatted(mes));
	}

	

	@AfterReturning(
			argNames = "val",
			value = "execution(* getCount(..))",
			returning = "val")
	public void afterReturn(JoinPoint joinPoint,int value) {
		ShowLogger.showLog(joinPoint, "After Return method!");
		ShowLogger.output("Return Value : "+value);
	}
	
	
	//@After("doSome()")
	public void after(JoinPoint joinPoint) {
		ShowLogger.showLog(joinPoint, "After method");
		
	}

	//@AfterThrowing("doSome()")
	public void afterThrow(JoinPoint joinPoint) {
		ShowLogger.showLog(joinPoint, "After Throwing method!");
	}

	//@Around("doSome()")
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
