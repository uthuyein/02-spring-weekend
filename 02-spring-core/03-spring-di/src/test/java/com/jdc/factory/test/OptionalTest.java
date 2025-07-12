package com.jdc.factory.test;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OptionalTest {

	@Test
	void test() {
		var opt = getValue("45");
		var str = opt.map(s -> Integer.parseInt(s)).orElse(60);
		System.out.println(str);
	}

	Optional<String> getValue(String message) {
		return Optional.ofNullable(message);
	}
}
