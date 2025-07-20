package com.jdc.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component
public class BeforeExecutionCustomAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("     ====================================");
		System.out.println("       Class :%s\t".formatted(target.getClass()));
		System.out.println("       method :%s\t".formatted(method.getName()));
		if (args.length > 0) {
			showArgs(args);
		}
		System.out.println("     ====================================".concat("\n"));
	}
	
	private static void showArgs(Object[] array) {
		System.out.print("       Args : ");
		for (int i = 0; i < array.length; i++) {
			var arg = array[i];

			System.out.printf("%s\t", arg);
		}
		System.out.println();
	}


}
