package com.codegym.service.impl;

import com.codegym.model.Cart;
import com.codegym.service.ICartService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService implements ICartService {

    @Override
    public void add(Map<Integer, Cart> cartMap, Cart cart) {
        Cart existedCart = cartMap.get(cart.getId());
        if (existedCart != null) {
            existedCart.setQuantity(cart.getQuantity() + 1);
        } else {
            cartMap.put(cart.getId(), cart);
        }
    }

    @Override
    public void remove(Map<Integer, Cart> cartMap, Integer id) {
        cartMap.remove(id);
    }


    @Override
    public double getAmount(Map<Integer, Cart> cartMap) {
        float payment = 0;
        for (Map.Entry<Integer, Cart> entry : cartMap.entrySet()) {
            payment += entry.getValue().getPrice() * entry.getValue().getQuantity();
        }
        return payment;
    }

    @Override
    public Integer getCount(Map<Integer, Cart> cartMap) {
        int count = 0;
        if (cartMap.isEmpty())
            return 0;
        for (Map.Entry<Integer, Cart> entry : cartMap.entrySet()) {
            count += entry.getValue().getQuantity();
        }
        return count;
    }
}
