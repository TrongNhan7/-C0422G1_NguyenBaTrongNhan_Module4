package com.codegym.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    @Column(name = "user_name")
    private String userName;
    private String password;

    @JsonBackReference(value = "employees")
    @OneToMany(mappedBy = "user")
    private Set<Employee> employees;

    @JsonBackReference(value ="userRoles")
    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles;

    public User() {
    }

    public User(String userName, String password, Set<Employee> employees, Set<UserRole> userRoles) {
        this.userName = userName;
        this.password = password;
        this.employees = employees;
        this.userRoles = userRoles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

//    public Set<UserRole> getUserRoles() {
//        return userRoles;
//    }
//
//    public void setUserRoles(Set<UserRole> userRoles) {
//        this.userRoles = userRoles;
//    }
}