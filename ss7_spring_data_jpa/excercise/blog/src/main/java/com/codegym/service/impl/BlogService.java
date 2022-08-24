package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBLogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBLogRepository ibLogRepository;

    @Override
    public Page<Blog> findByTitle(String title, Integer id, Pageable pageable) {
        if (id.equals(0)) {
            return ibLogRepository.findByTitle(title, pageable);
        }
        return ibLogRepository.findByTitle(title, id, pageable);
    }

    @Override
    public void save(Blog blog) {
        ibLogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return ibLogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        Blog blog = findById(id);
        blog.setStatus(true);
        ibLogRepository.save(blog);
    }
}
