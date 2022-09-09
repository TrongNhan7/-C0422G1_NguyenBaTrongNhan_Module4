package com.codegym.util;

import com.codegym.dto.CustomerDto;
import org.springframework.validation.Errors;

import java.time.LocalDate;
import java.time.Period;

public class DateTime18Util {
    public static void checkDate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        LocalDate localDateNow = LocalDate.now();
        LocalDate birthday = null;
        int age = 0;
        try {
            birthday = LocalDate.parse(customerDto.getBirthday());
            age = Period.between(birthday, localDateNow).getYears();
            if (age < 18) {
                errors.rejectValue("birthday", "create.birthday", "Trên 18+ mới dc nha!");
            }
        } catch (Exception e) {
            errors.rejectValue("birthday", "create.birthday", "Nhập thứ gì đó!");
        }
    }
}
