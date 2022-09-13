package com.codegym.service;

import com.codegym.model.contract.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    AttachFacility findById(Integer id);

    List<AttachFacility> findAllByIdContract(Integer id);
}
