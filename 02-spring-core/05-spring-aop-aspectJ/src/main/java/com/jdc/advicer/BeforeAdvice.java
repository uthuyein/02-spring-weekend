package com.jdc.advicer;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import com.jdc.utils.ShowLogger;

@Component
public class BeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("     ====================================");
		System.out.println("       Class :%s\t".formatted(target.getClass()));
		System.out.println("       method :%s\t".formatted(method.getName()));
		
		if (args.length > 0) {
			ShowLogger.showArgs(args);
		}
		System.out.println("     ====================================".concat("\n"));

	}

}
