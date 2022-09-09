package com.codegym.service;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface ICustomerService {

    Page<Customer> findAllByName(String keywordVal, Pageable pageable);

    Page<Customer> findAll(Pageable pageable);

    Customer save(Customer customer);

    Customer findById(int id);

    void deleteById(int id);
}
