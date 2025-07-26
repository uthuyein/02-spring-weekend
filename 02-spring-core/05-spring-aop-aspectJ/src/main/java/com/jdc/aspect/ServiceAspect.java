package com.jdc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.jdc.dto.MyDefaultService;
import com.jdc.dto.MyService;
import com.jdc.utils.ShowLogger;

@Component
@Aspect
public class ServiceAspect {
	
	@DeclareParents(
			value = "com.jdc.dto.MyEmployeeService",
			defaultImpl = MyDefaultService.class)
	public static MyService service;

	@Pointcut("within(com.jdc.dto.*Service)")
	public void doSome() {
	}
	
	
	@Pointcut("execution(* sale())")
	public void doSomeArgs() {
	}
	
	@Before(argNames = "mess",
			value = "execution(* setData(..)) and args(mess,..)")
	public void before(JoinPoint joinpoint, String mes) {
		ShowLogger.showLog(joinpoint, "Before execution method !");
		ShowLogger.output("Args values :%s".formatted(mes));
	}

	@AfterReturning(
			argNames = "dat,val",//can't change args list order
			value = "execution(* getCount(..)) and args(val)",
			returning = "dat")
	public void afterReturn(JoinPoint joinPoint,int value,String data) {
		ShowLogger.showLog(joinPoint, "After Return method!");
		ShowLogger.output("Return Value : "+value);
		ShowLogger.output("Args Value : "+data);
	}
	
	
	@After("doSome() && doSomeArgs()")
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
