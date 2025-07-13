package com.jdc.utils;

import org.aspectj.lang.JoinPoint;

public class ShowLogger {

	public static void showLog(JoinPoint joinpoint,String message) {
		
		var ownerClass = joinpoint.getTarget().getClass();
		var proxy = joinpoint.getThis().getClass();
		var advice = joinpoint.toLongString();
		
		System.out.println("     ====================================");
		System.out.println("       Proxy :%s\t".formatted(proxy));
		System.out.println("       Class :%s\t".formatted(ownerClass));
		System.out.println("       advice :%s\t".formatted(advice));
		System.out.println("     ====================================".concat("\n"));
		System.out.println("       Message : "+message);
		
	}
	
	
}
