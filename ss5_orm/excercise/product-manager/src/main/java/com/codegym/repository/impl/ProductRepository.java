package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    private static final String SELECT_BY_ID = "select p from Product as p where p.id = :id";

    @Override
    public List<Product> findByName(String name) {
        if (name == null) {
            TypedQuery typedQuery = BaseRepository.entityManager.createQuery("select p from Product p", Product.class);
            return typedQuery.getResultList();
        } else {
            TypedQuery typedQuery = BaseRepository.entityManager.createQuery("select p from Product p where p.name like concat('%',:name,'%') ", Product.class);
            typedQuery.setParameter("name", name);
            return typedQuery.getResultList();
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
