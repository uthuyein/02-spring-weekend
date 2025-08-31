package com.jdc.mkt.converter;

import com.jdc.mkt.entity.Circle;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CircleConverter implements AttributeConverter<Circle, String>{

	@Override
	public String convertToDatabaseColumn(Circle attribute) {
		return attribute.toString();
	}

	@Override
	public Circle convertToEntityAttribute(String dbData) {
		String[] array = dbData.split(":");
		var circle = new Circle(Double.valueOf(array[0]), array[1]);
		return circle;
	}

	
}
