package com.codegym.service;


import com.codegym.model.Blog;
import java.util.List;


public interface IBlogService {

    List<Blog> findByTitle(String title);

    void save(Blog blog);

    Blog findById(Integer id);

    void delete(Integer id);
}
