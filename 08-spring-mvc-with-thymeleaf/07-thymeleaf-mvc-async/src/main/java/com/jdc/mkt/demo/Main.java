package com.jdc.mkt.demo;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Start Application");
		System.out.println("run business logic");
		
		new Thread(() -> {
			try {
				useMethod();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} ).start(); 
		new Thread(() -> {
			try {
				useMethod();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} ).start(); 
		
		System.out.println("End process");

	}
	
	static void useMethod() throws InterruptedException {
		Thread.sleep(2000L);
		System.out.println("Thread 2 : Waiting process 2 seconds");
	}
}
