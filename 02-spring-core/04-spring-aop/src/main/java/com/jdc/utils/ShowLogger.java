package com.jdc.utils;

import org.aspectj.lang.JoinPoint;

public class ShowLogger {

	public static void showLog(JoinPoint joinpoint,String message) {
		
		var method = joinpoint.getTarget().getClass();
		var proxy = joinpoint.getThis().getClass();
		var point = joinpoint.toLongString();
		
		System.out.println("     ====================================");
		System.out.println("       Proxy :%s\t".formatted(proxy));
		System.out.println("       method :%s\t".formatted(method));
		System.out.println("       point :%s\t".formatted(point));
		System.out.println("     ====================================".concat("\n"));
		System.out.println("       Message : "+message);
		
	}
}
