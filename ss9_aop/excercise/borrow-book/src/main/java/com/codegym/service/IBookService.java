package com.codegym.service;

import com.codegym.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void borrowBook(Integer id);

    void backBook(Integer id);

   Book findById(Integer id);
}
