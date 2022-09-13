package com.codegym.service.impl;

import com.codegym.model.employee.Education;
import com.codegym.repository.IEducationDegreeRepository;
import com.codegym.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements IEducationService {

    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<Education> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
