package com.jdc.beans;

public class LambdaDemo {
	
	public static void main(String[] args) {
		// Before Lambda
		MyInter inter1 = new MyInter() {

			@Override
			public String show(String st,int a) {
				System.out.println("Show without using lambda !"+name);
				
				return name;
			}
			
		};
		inter1.show("sss",22);
		//After lambda
		MyInter inter2 = (str,a) -> str;
		
		inter2.show("aaa",12);
		
		setInter((str,a) -> str);
	
	}
	
	static void setInter(MyInter inter) {
		 String name = "no name";
		
		class Hello{
			void showName() {
				System.out.println(name);
			}
		}
		Hello h = new Hello();
		h.showName();
		
		//name = "Aung Aung";
	}
	
	static MyInter getInter() {
		return null;
	}
}

@FunctionalInterface
interface MyInter{
	
	String name = "no name";
	
	//SAM
	String show(String str,int a);
	
	
	default void doSomething() {
		System.out.println("Do something with default");
	}
	
	static void hide() {
		System.out.println("Using with static");
	}
}
