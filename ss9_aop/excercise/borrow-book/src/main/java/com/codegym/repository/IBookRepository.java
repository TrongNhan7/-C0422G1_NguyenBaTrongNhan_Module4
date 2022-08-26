package com.codegym.repository;

import com.codegym.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Modifying
    @Query(value = "update book set remaining = remaining - 1 where id= :id ", nativeQuery = true)
    void borrowBook(@Param("id") Integer id);

    @Modifying
    @Query(value = "update book set remaining = remaining + 1 where id= :id ", nativeQuery = true)
    void backBook(@Param("id") Integer id);
}

