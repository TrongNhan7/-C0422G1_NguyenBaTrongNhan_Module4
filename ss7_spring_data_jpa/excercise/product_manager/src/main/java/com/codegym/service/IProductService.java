package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IProductService {
    Page<Product> findByName(String name, Pageable pageable);

    void save(Product product);


    void delete(int id);

    Product findById(int id);
}
