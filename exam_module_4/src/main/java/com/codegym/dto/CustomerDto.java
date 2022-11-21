package com.codegym.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDto{

    private Integer id;
    @NotBlank(message = "Nhập vào đi bạn ơi!")
    private String name;

    @NotBlank(message = "Nhập vào đi bạn ơi!")
    @Pattern(regexp = "^((090)|(091)|(\\\\(84\\\\)+90)|(\\\\(84\\\\)+91))[0-9]{7}$",
            message = "Nhập số điện thoại Việt Nam")
    private String phone;

    @Email(message = "Email phải đúng định dạng vd: giothoitb7@gmail.com")
    private String email;

    public CustomerDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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



}
