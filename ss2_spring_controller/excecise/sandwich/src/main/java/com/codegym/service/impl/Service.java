package com.codegym.service.impl;

import com.codegym.service.IService;

@org.springframework.stereotype.Service
public class Service implements IService {
    @Override
    public String[] condiments(String[] listCondiment) {
        if (listCondiment == null) {
            return listCondiment = new String[]{"Null"};
        } else {
            return listCondiment;
        }
    }
}
