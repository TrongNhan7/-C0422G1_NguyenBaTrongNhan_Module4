package com.codegym.repository;

import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    Page<Facility> findAllByNameServiceContaining(Pageable pageable, String name);

    Page<Facility> findAllByNameServiceContainingAndFacilityType(Pageable pageable, String name, FacilityType type);

}