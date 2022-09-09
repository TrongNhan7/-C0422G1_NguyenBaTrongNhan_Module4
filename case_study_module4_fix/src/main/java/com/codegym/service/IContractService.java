package com.codegym.service;

import com.codegym.model.contract.Contract;
import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAllByDay(Pageable pageable, String keyword);

    Page<Contract> findAll(Pageable pageable);

    Double findTotalMoney(Integer id);

    Contract save(Contract contract);

    Contract findById(Integer id);

    void deleteById(Integer id);
}
