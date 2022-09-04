package com.codegym.service;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAllByName(Pageable pageable, String keyword);

    Page<Employee> findAll(Pageable pageable);

    Employee save(Employee employee);

    Employee findById(Integer id);

    void deleteById(Integer id);
}
