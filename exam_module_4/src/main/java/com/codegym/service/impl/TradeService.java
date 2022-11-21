package com.codegym.service.impl;

import com.codegym.model.Trade;
import com.codegym.repository.ITradeRepository;
import com.codegym.service.ITradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TradeService implements ITradeService {

    @Autowired
    private ITradeRepository iTradeRepository;

    @Override
    public Page<Trade> findAllByName(Pageable pageable, String id) {
        return iTradeRepository.findAllByIdContaining(pageable, id);
    }

    @Override
    public Trade save(Trade trade) {
        return iTradeRepository.save(trade);
    }

    @Override
    public Trade findByIdTrade(String id) {
        return iTradeRepository.findByIdTrade(id);
    }
}
