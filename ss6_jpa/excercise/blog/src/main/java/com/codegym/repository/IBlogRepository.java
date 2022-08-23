package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

//    @Query(value = "update Blog set status = 1 where id = :id", nativeQuery = true)
//    void deletes(@Param("id") Integer id);

    @Query(value = "select  * from Blog where status=0 and blog.title like concat('%',:title,'%') ", nativeQuery = true)
    List<Blog> findByTitle(@Param("title") String title);
}
