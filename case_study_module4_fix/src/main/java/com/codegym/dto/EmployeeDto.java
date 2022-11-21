package com.codegym.dto;

import com.codegym.model.employee.Division;
import com.codegym.model.employee.Education;
import com.codegym.model.employee.Position;
import com.codegym.model.employee.User;

import javax.validation.constraints.*;

public class EmployeeDto{

    private Integer id;

    @Pattern(regexp = "^[A-Z][A-Za-z]*(\\s[A-Z][A-Za-z]*){0,20}$",
            message = "Nhập chữ cái đàu viết hoa")
    private String name;

    @NotNull(message = "Nghập ì đó đi !")
    private String birthday;

    @Pattern(regexp = "^[0-9]{9}|[0-9]{12}$",
            message = "Nhập Cmnd phải 9 hoặc 12 số")
    private String idCard;

    @Min(value = 0, message = "Nhập số lớn hơn 0")
    private Double salary;

    @Pattern(regexp = "^((090)|(091)|(\\\\(84\\\\)+90)|(\\\\(84\\\\)+91))[0-9]{7}$",
            message = "Nhập số điện thoại Việt Nam")
    private String phoneNumber;

    @Email(message = "Email phải đúng định dạng vd: giothoitb7@gmail.com")
    private String email;

    @NotBlank(message = "Nhập vào đi bạn ơi!")
    private String address;


    private Position position;

    private Education education;

    private Division division;

    private User user;

    public EmployeeDto() {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
