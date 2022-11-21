package com.codegym.util;

import org.springframework.validation.Errors;

import java.time.LocalDate;

public class ValidateExam {

    public static void checkStartDate(String field, String startDate, Errors error) {
        LocalDate now = LocalDate.now();

        if (startDate.equals("")) {
            error.rejectValue(field, "startDate.create", "Nhập ngày dô bạn ơi");
        } else {
            LocalDate startDate1 = LocalDate.parse(startDate);
            if (startDate1.compareTo(now) < 0) {
                error.rejectValue(field, "startDate.create", "Không nhập ngày quá khứ");
            }
        }
    }

    public static void checkDouble(String field, Double value, Errors error) {
        if (value == null) {
            error.rejectValue(field, "field", "Nhập gì đó đi fren!");
        } else if (value < 0) {
            error.rejectValue(field, "field", "Nhập số > 0 nha");
        }
    }
}
