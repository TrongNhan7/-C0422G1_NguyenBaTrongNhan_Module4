package com.codegym.service;

import com.codegym.model.contract.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    List<AttachFacility> findAllByIdContract(Integer id);
}
