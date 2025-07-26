package com.jdc.utils;

import org.aspectj.lang.JoinPoint;

public class ShowLogger {

	public static void showLog(JoinPoint joinpoint, String message) {

		var ownerClass = joinpoint.getTarget().getClass();
		var proxy = joinpoint.getThis().getClass();
		var pointcut = joinpoint.toLongString();
		var method = joinpoint.getSignature();
		var args = joinpoint.getArgs();
		
		System.out.println("     ====================================");
		System.out.println("       ------ " + message + " -------");
		System.out.println("       Proxy :%s\t".formatted(proxy));
		System.out.println("       Class :%s\t".formatted(ownerClass));
		System.out.println("       pointcut :%s\t".formatted(pointcut));
		System.out.println("       method :%s\t".formatted(method.getName()));
		if (args.length > 0) {
			showArgs(args);
		}
		System.out.println("     ====================================".concat("\n"));

	}

	public static void showArgs(Object[] array) {
		System.out.print("       Args : ");
		for (int i = 0; i < array.length; i++) {
			var arg = array[i];

			System.out.printf("%s\t", arg);
		}
		System.out.println();
	}

	public static void output(String message) {
		System.out.println("       %s\n".formatted(message));
	}

}
