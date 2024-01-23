package com.example.convert;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

@Convert
public class BooleanConverter implements AttributeConverter<Boolean, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Boolean attribute) {
		return attribute == Boolean.TRUE ? 1 : -1;
	}

	@Override
	public Boolean convertToEntityAttribute(Integer dbData) {
		return (dbData != null && dbData == 1) ? Boolean.TRUE : Boolean.FALSE;
	}

}
