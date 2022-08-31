package com.codegym.service.impl;

import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import com.codegym.repository.IFacilityRepository;
import com.codegym.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAllByName(Pageable pageable, String keywordVal, FacilityType type) {
        if (type == null) {
            return iFacilityRepository.findAllByNameServiceContaining(pageable, keywordVal);
        }
        return iFacilityRepository.findAllByNameServiceContainingAndAndFacilityType(pageable, keywordVal, type);
    }

    @Override
    public Facility save(Facility facility) {
        return null;
    }

    @Override
    public Facility findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
