package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final String SELECT_ALL_PRODUCT = "select p from Product as p";
    private static final String SELECT_BY_ID = "select p from Product as p where p.id = :id";

    @Override
    public List<Product> findAll(String name) {
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(SELECT_ALL_PRODUCT, Product.class);
        if (name == null) {
            return query.getResultList();
        } else {
            List<Product> products = new ArrayList<>();
            for (Product product : query.getResultList()) {
                if (product.getName().contains(name)) {
                    products.add(product);
                }
            }
            return products;
        }
    }

    @Override
    public void addProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void edit(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Product.class, id));
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(SELECT_BY_ID, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
