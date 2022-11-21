package com.codegym.dto;


import com.codegym.util.DateTime18Util;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {

    private Integer id;
    @NotBlank(message = "Nhập vào đi bạn ơi!")
    private String customerName;
    private String birthday;

    private boolean gender;
    private String idCard;
    @NotBlank(message = "Nhập vào đi bạn ơi!")
    @Pattern(regexp = "^((090)|(091)|(\\\\(84\\\\)+90)|(\\\\(84\\\\)+91))[0-9]{7}$",
            message = "Nhập số điện thoại Việt Nam")
    private String phone;
    @NotBlank(message = "Nhập vào đi bạn ơi!")
    @Email(message = "Email phải đúng định dạng vd: giothoitb7@gmail.com")
    private String email;
    @NotBlank(message = "Nhập vào đi bạn ơi!")
    private String address;
    private boolean status;
    private CustomerTypeDto customerType;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, @NotBlank(message = "Nhập vào đi bạn ơi!") String customerName, String birthday, @NotBlank(message = "Nhập vào đi bạn ơi!") boolean gender, String idCard, @NotBlank(message = "Nhập vào đi bạn ơi!") @Pattern(regexp = "^((090)|(091)|(\\\\(84\\\\)+90)|(\\\\(84\\\\)+91))[0-9]{7}$",
            message = "Nhập số điện thoại Việt Nam") String phone, @NotBlank(message = "Nhập vào đi bạn ơi!") @Email(message = "Email phải đúng định dạng vd: giothoitb7@gmail.com") String email, @NotBlank(message = "Nhập vào đi bạn ơi!") String address, boolean status, CustomerTypeDto customerType) {
        this.id = id;
        this.customerName = customerName;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.customerType = customerType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CustomerTypeDto getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerTypeDto customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        DateTime18Util.checkDate(target, errors);

        String name = customerDto.getCustomerName();
        if (!name.matches("^[A-Z][A-Za-z]*(\\s[A-Z][A-Za-z]*){0,20}$")) {
            errors.rejectValue("customerName", "customerName.create", "Ký tự đầu tiên mỗi từ phải viết hoa");
        }

        String idCard = customerDto.getIdCard();
        if (!idCard.matches("^[0-9]{9}|[0-9]{12}$")) {
            errors.rejectValue("idCard", "idCard.create", "CMND phải theo định dạng 9 hoặc 12 số");
        }

//
//        if (!(customerDto.dayOfBirth == null || customerDto.dayOfBirth.equals(""))) {
//            try {
//                LocalDate.parse(customerDto.dayOfBirth);
//            } catch (Exception e) {
//                errors.rejectValue("dayOfBirth", "day.err", "please input right format");
//            }
//        }

    }
}
