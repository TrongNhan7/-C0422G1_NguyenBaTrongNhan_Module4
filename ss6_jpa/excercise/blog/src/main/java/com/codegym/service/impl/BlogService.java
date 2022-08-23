package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iblogRepository;


    @Override
    public List<Blog> findByTitle(String title) {
        return iblogRepository.findByTitle(title);
    }


    @Override
    public Blog findById(Integer id) {
        return iblogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        iblogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        Blog blog = findById(id);
        blog.setStatus(true);
        iblogRepository.save(blog);
    }
}
