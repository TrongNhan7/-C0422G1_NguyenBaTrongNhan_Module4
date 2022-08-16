package com.codegym.service.impl;

import com.codegym.service.IConversionService;
import org.springframework.stereotype.Service;

@Service
public class ConversionService implements IConversionService {

    @Override
    public double convertCurrency(double money, double rate) {
        return money * rate;
    }
}
