package com.codegym.repository;

import com.codegym.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
