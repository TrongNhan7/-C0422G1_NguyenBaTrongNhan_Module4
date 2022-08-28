package com.codegym.repository;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//    @Query(value = "call find_by_sp(:key)", nativeQuery = true)
//    Page<Customer> findCustomerByName(@Param("key") String key);

    @Query(value = "select * from customer where customer_name like concat('%',:keyword,'%') and `status` = 0", nativeQuery = true,
            countQuery = "select count(*) from (select * from customer where customer_name like concat('%',:keyword,'%') and `status` = 0) customer")
    Page<Customer> findAllByName(@Param("keyword") String keywordVal, Pageable pageable);

}
