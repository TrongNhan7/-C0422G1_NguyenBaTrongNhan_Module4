package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlogService {

    Page<Blog> findByTitle(String title, Integer id, Pageable pageable);

    void save(Blog blog);

    Blog findById(Integer id);

    void delete(Integer id);
}
