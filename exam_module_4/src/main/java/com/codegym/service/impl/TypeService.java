package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repository.ITypeRepository;
import com.codegym.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService {

    @Autowired
    private ITypeRepository iTypeRepository;


    @Override
    public List<com.codegym.model.TypeService> findAll() {
        return iTypeRepository.findAll();
    }
}
