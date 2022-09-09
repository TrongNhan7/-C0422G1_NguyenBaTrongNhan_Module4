package com.codegym.util;

import org.springframework.validation.Errors;

import java.time.LocalDate;


public class Validation {

    private static final String FACILITY_NAME_REGEX = "^([A-Z]\\w*)+(\\s[A-Z]\\w*)*$";

    public static void checkFacilityName(String field, String facilityName, Errors error) {
        if(facilityName.equals("")){
            error.rejectValue(field, "field.create", "Nhập tên dô fren!");
        } else if (!facilityName.matches(FACILITY_NAME_REGEX)) {
            error.rejectValue(field, "field.create", "Nhập tên dịch vụ có chữ cái đầu viết hoa");
        }
    }

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

    public static void checkEndDate(String field, String startDate, String endDate, Errors error) {
        if (endDate.equals("")) {
            error.rejectValue(field, "endDate.create", "Nhập ngày dô bạn ơi");
        } else if (endDate.compareTo(startDate) < 0) {
            error.rejectValue(field, "endDate.create", "Ngày kết thúc không trước ngày bắt đầu");
        }
    }

    public static void checkDouble(String field, Double value, Errors error) {
        if (value == null) {
            error.rejectValue(field, "field", "Nhập gì đó đi fren!");
        } else if (value < 0) {
            error.rejectValue(field, "field", "Nhập số > 0 nha");
        }
    }

    public static void checkInteger(String field, String value, Errors error) {
        if (!value.matches("[0-9]+")) {
            error.rejectValue(field, "field.create", "Phải số nguyên dương nha");
        }
    }
}
