package com.jdc.mkt.demo;

import java.util.concurrent.Callable;

public class ExecutorDemo {

	public static void main(String[] args) throws Exception {
		
		
	}

	static Runnable getRunnable() {
		return new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnable String");
			}
		};
	}

	static Callable<String> getCallable() {
		return new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Callable String";
			}
		};
	}
}
