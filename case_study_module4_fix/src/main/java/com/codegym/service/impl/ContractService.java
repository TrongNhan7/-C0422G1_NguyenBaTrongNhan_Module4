package com.codegym.service.impl;

import com.codegym.model.contract.Contract;
import com.codegym.repository.IContractRepository;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAllByDay(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public Double findTotalMoney(Integer id) {
        return iContractRepository.findTotalMoney(id);
    }

    @Override
    public Contract save(Contract contract) {
        return iContractRepository.save(contract);
    }

    @Override
    public Contract findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Contract findContractLast() {
        return iContractRepository.findContractLast();
    }
}
