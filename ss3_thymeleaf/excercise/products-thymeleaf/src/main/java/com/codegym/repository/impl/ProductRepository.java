package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static Map<Integer, Product> productList;

    static {

        productList = new HashMap<>();
        productList.put(1, new Product(1, "K149", 420.5, "Chạy phụt trước", "Kia"));
        productList.put(2, new Product(2, "K150", 480.7, "Chạy nhíp trước", "Kia"));
        productList.put(3, new Product(3, "Bus", 999.9, "Cao cấp", "Thaco"));
        productList.put(4, new Product(4, "FD500", 777.7, "Ben nặng", "Forland"));

    }

    @Override
    public List<Product> findAll(String name) {
        if (name == null) {
            return new ArrayList<>(productList.values());
        } else {
            List<Product> products = new ArrayList<>();
            for (Product product : productList.values()) {
                if (product.getName().contains(name)) {
                    products.add(product);
                }
            }
            return products;
        }
    }

    @Override
    public void addProduct(Product product) {
        int id = 0;
        int max = 0;
        if (productList == null) {
            id = 1;
        } else {
            for (Product items : productList.values()) {
                if (items.getId() > max) {
                    max = items.getId();
                }
            }
        }
        id = max + 1;
        product.setId(id);
        productList.put(id, product);
    }

    @Override
    public void edit(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }


//    public List<Product> findByName(String name) {
//        List<Product> products = new ArrayList<>();
//        for (Product product : productList.values()) {
//            if (product.getName().contains(name)) {
//                products.add(product);
//            }
//        }
//        return products;
//    }
}
