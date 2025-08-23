package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Objects;

import org.junit.jupiter.api.Test;

public class HashTest {

	@Test
	void test() {
		var h1 = new Human("Aung Aung",20);
		var h2 = new Human("Aung Aung",20);
		
		var res = h1.equals(h2);
		assertEquals(res, true);
	}
}

class Human{
	String name;
	int age;
	
	Human(String name,int age){
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
}
