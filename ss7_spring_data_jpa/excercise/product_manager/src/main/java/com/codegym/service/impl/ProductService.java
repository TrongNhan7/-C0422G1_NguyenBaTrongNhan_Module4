package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findByName(String name, Pageable pageable) {
        return iProductRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }


    @Override
    public void delete(int id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }
}
