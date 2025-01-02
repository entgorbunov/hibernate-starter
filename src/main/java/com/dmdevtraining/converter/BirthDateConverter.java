package com.dmdevtraining.converter;

import com.dmdevtraining.entity.Birthdate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.util.Optional;

@Converter(autoApply = true)
public class BirthDateConverter implements AttributeConverter<Birthdate, Date> {

    @Override
    public Date convertToDatabaseColumn(Birthdate birthdate) {
        return Optional.ofNullable(birthdate)
            .map(Birthdate::birthDate)
            .map(Date::valueOf)
            .orElse(null);
    }

    @Override
    public Birthdate convertToEntityAttribute(Date date) {
        return Optional.ofNullable(date)
            .map(Date::toLocalDate)
            .map(Birthdate::new)
            .orElse(null);
    }
}
