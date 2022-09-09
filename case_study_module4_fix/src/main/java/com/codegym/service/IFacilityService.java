package com.codegym.service;

import com.codegym.model.customer.Customer;
import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> findAllByName(Pageable pageable, String keywordVal, FacilityType type);

    Page<Facility> findAll(Pageable pageable);

    Facility save(Facility facility);

    Facility findById(Integer id);

    void deleteById(Integer id);
}
