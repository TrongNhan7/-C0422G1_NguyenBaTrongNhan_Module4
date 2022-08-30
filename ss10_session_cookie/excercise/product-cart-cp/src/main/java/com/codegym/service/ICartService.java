package com.codegym.service;

import com.codegym.model.Cart;

import java.util.Map;

public interface ICartService {


    void add(Map<Integer, Cart> cartMap, Cart cart);

    void decreate(Map<Integer, Cart> cartMap, Cart cart);

    void remove(Map<Integer, Cart> cartMap, Integer id);

    double getAmount(Map<Integer, Cart> cartMap);

    Integer getCount(Map<Integer, Cart> cartMap);
}
