package com.codegym.controller;


import com.codegym.model.contract.Contract;
import com.codegym.service.IContractService;
import com.codegym.service.ICustomerService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IFacilityService;
import com.codegym.service.impl.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping("")
    public String showContract(Model model, @RequestParam(defaultValue = "") String keyword,
                               @PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC)
                               Pageable pageable) {
        Page<Contract> contracts = iContractService.findAll(pageable);
//
//        List list = new ArrayList<>();
//        for (Contract contract : contracts) {
//            list.add(iContractService.findTotalMoney(contract.getId()));
//        }
//
        for (Contract contract : contracts) {
            contract.setTotalMoney(iContractService.findTotalMoney(contract.getId()));
        }

        model.addAttribute("contractList", iContractService.findAll(pageable));
//        model.addAttribute("list", list);

        return "/contract/con-list";
    }
}
