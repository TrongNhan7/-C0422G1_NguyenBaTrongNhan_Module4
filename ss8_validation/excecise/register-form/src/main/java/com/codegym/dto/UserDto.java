package com.codegym.dto;

import com.codegym.util.DateTimeUtil;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

public class UserDto implements Validator {

    @NotBlank(message = "Nhập vào đi bạn ơi!")
    @Size(min = 5, max = 45, message = "Độ dài từ 5 đến 45 ký tự")
    private String firstName;

    @NotBlank(message = "Nhập vào đi bạn ơi!")
    @Size(min = 5, max = 45, message = "Độ dài từ 5 đến 45 ký tự")
    private String lastName;

    @NotBlank(message = "Nhập vào đi bạn ơi!")
    @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})$", message = "Nhập số điện thoại Việt Nam")
    private String phoneNumber;

    private String age;

    @NotBlank(message = "Nhập vào đi bạn ơi!")
    @Email(message = "Nhập đúng định dạng mail")
    private String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String phoneNumber, String age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        DateTimeUtil dateTimeUtil = new DateTimeUtil();
        dateTimeUtil.checkDate(target,errors);
    }
}
