package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlogService {

    Page<Blog> findByTitleAndCategory(String title, Integer id, Pageable pageable);

    Page<Blog> findByTitle(String title, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByIdCategory(Integer id, Pageable pageable);

    void save(Blog blog);

    Blog findById(Integer id);

    void delete(Integer id);
}
