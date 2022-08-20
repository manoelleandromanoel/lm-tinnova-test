package org.example.lm.tinnova.test.exercise_5.domain.converter;

import org.example.lm.tinnova.test.exercise_5.domain.Brand;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BrandConverter implements AttributeConverter<Brand, Integer> {

    @Override
    public Integer convertToDatabaseColumn(final Brand attribute) {
        return attribute.getCode();
    }

    @Override
    public Brand convertToEntityAttribute(final Integer dbData) {
        return Brand.valueOf(dbData);
    }
}
