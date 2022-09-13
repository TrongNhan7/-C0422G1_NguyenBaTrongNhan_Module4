package com.codegym.repository;

import com.codegym.model.employee.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationDegreeRepository extends JpaRepository<Education,Integer> {
}
