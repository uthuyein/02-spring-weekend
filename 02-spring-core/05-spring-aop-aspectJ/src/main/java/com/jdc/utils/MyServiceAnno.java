package com.jdc.utils;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

@Component
@Documented
@Retention(RUNTIME)
@Target({ElementType.TYPE})
public @interface MyServiceAnno {

	
}
