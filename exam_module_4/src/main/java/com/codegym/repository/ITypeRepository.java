package com.codegym.repository;

import com.codegym.model.TypeService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Type;

public interface ITypeRepository extends JpaRepository<TypeService,Integer> {
}
