package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IBLogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select  * from Blog where status=0 and blog.title like concat('%',:title,'%') and blog.id_category = :id  ", nativeQuery = true,
            countQuery = "select count(*) from (select  * from Blog where status=0 and blog.title like concat('%',:title,'%')) table_name ")
    Page<Blog> findByTitleAndCategory(@Param("title") String title,@Param("id") Integer id, Pageable pageable);

    @Query(value = "select  * from Blog where status=0 and blog.title like concat('%',:title,'%') ", nativeQuery = true,
            countQuery = "select count(*) from (select  * from Blog where status=0 and blog.title like concat('%',:title,'%')) table_name ")
    Page<Blog> findByTitleAndCategory(@Param("title") String title, Pageable pageable);

}
