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
        return iFacilityRepository.findAllByNameServiceContainingAndFacilityType(pageable, keywordVal, type);
    }

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return iFacilityRepository.findAll(pageable);
    }

    @Override
    public Facility save(Facility facility) {
        return iFacilityRepository.save(facility);
    }

    @Override
    public Facility findById(Integer id) {
        return iFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        iFacilityRepository.deleteById(id);
    }
}
