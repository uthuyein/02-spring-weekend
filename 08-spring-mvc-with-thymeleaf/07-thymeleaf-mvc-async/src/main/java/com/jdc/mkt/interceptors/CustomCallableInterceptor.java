package com.jdc.mkt.interceptors;

import java.util.concurrent.Callable;

import org.jspecify.annotations.Nullable;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;

public class CustomCallableInterceptor implements CallableProcessingInterceptor {

	@Override
	public <T> void afterCompletion(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("Callable : Complete Process");
	}
	
	@Override
	public <T> void preProcess(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("Callable : Pre Process");
	}
	
	@Override
	public <T> void postProcess(NativeWebRequest request, Callable<T> task, @Nullable Object concurrentResult)
			throws Exception {
		System.out.println("Callable : Post Process");
	}
	
	
}
