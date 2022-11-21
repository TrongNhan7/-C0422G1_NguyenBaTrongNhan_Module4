package com.codegym.service;

import com.codegym.model.Trade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITradeService {
    Page<Trade> findAllByName(Pageable pageable, String id);

    Trade save(Trade trade);

    Trade findByIdTrade(String id);
}
