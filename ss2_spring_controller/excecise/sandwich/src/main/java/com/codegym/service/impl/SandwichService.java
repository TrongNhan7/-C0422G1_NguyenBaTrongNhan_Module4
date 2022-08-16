package com.codegym.service.impl;

import com.codegym.repository.ISandwichRepository;
import com.codegym.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class SandwichService implements ISandwichService {

    @Autowired
    private ISandwichRepository iSandwichRepository;

    @Override
    public List<String> findAllCondiments() {
        return iSandwichRepository.findAllCondiments();
    }
}
