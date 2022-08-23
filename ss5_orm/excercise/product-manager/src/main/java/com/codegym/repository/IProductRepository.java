package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findByName(String name);

    void addProduct(Product product);

    void edit(Product product);

    void delete(int id);

    Product findById(int id);

}
