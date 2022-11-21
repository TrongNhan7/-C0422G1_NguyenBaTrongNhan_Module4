package com.codegym.repository;

import com.codegym.model.Trade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITradeRepository extends JpaRepository<Trade, String> {
    Page<Trade> findAllByIdContaining(Pageable pageable, String id);

    @Query(value = "select * from trade where id like :id", nativeQuery = true)
    Trade findByIdTrade(@Param("id") String id);
}

