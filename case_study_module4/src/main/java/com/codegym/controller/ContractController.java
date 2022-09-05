package com.codegym.controller;


import com.codegym.dto.ContractDto;
import com.codegym.dto.FacilityDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.facility.Facility;
import com.codegym.service.IContractService;
import com.codegym.service.ICustomerService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IFacilityService;
import com.codegym.service.impl.FacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
                               @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC)
                                       Pageable pageable) {
        Page<Contract> contracts = iContractService.findAll(pageable);

        for (Contract contract : contracts) {
            if (iContractService.findTotalMoney(contract.getId()) != null)
                contract.setTotalMoney(iContractService.findTotalMoney(contract.getId()));
        }

        model.addAttribute("contractList", iContractService.findAll(pageable));

        return "/contract/con-list";
    }

    @GetMapping("/create")
    public String createContract(Model model, Pageable pageable) {
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("employeeList", iEmployeeService.findAll(pageable));
        model.addAttribute("customerList", iCustomerService.findAll(pageable));
        model.addAttribute("facilityList", iFacilityService.findAll(pageable));
        return "/contract/con-create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute(value = "contractDto") @Valid ContractDto contractDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                 Model model, Pageable pageable) {
        new ContractDto().validate(contractDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("employeeList", iEmployeeService.findAll(pageable));
            model.addAttribute("customerList", iCustomerService.findAll(pageable));
            model.addAttribute("facilityList", iFacilityService.findAll(pageable));
            return "/contract/con-create";
        }

        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);

        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/contract";
    }
}
