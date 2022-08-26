package com.codegym.util;

import com.codegym.dto.UserDto;
import org.springframework.validation.Errors;

import java.time.LocalDate;
import java.time.Period;

public class DateTimeUtil {

    public void checkDate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        LocalDate localDateNow = LocalDate.now();
        LocalDate birthday = null;
        int years = 0;
        try {
            birthday = LocalDate.parse(userDto.getAge());
            years = Period.between(birthday, localDateNow).getYears();
            if (years < 18) {
                errors.rejectValue("age", "create.age", "Trên 18+ mới dc nha!");
            }
        } catch (Exception e) {
            errors.rejectValue("age", "create.age", "Nhập thứ gì đó!");
        }
    }
}
