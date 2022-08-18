package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void addProduct(Product product);

    void edit(Product product);

    void delete(int id);

    Product findById(int id);

    List<Product> findByName(String name);

}
