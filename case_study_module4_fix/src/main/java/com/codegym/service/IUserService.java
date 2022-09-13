package com.codegym.service;

import com.codegym.model.employee.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
}
