package com.codegym.controller;


import com.codegym.dto.ContractDetailDto;
import com.codegym.dto.ContractDto;
import com.codegym.dto.FacilityDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.facility.Facility;
import com.codegym.service.*;
import com.codegym.service.impl.FacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @ModelAttribute(value = "contractList")
    public Page<Contract> getAllContract(@PageableDefault(size = 5, sort = "id",
            direction = Sort.Direction.ASC)
                                                 Pageable pageable) {
        Page<Contract> contractList = this.iContractService.findAll(pageable);
        return contractList;
    }

    @GetMapping("")
    public String showContract(Model model, @RequestParam(defaultValue = "") String keyword,
                               @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC)
                                       Pageable pageable) {
        Page<Contract> contracts = iContractService.findAll(pageable);

        for (Contract contract : contracts) {
            if (iContractService.findTotalMoney(contract.getId()) != null)
                contract.setTotalMoney(iContractService.findTotalMoney(contract.getId()));
        }
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
//        model.addAttribute("contractList", iContractService.findAll(pageable));

        return "/contract/con-list";
    }

//    @GetMapping
//    public ResponseEntity<Page<Contract>> allContract(Model model, @RequestParam(defaultValue = "") String keyword,
//                                                      @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC)
//                                                              Pageable pageable) {
//        Page<Contract> contracts = iContractService.findAll(pageable);
//        for (Contract contract : contracts) {
//            if (iContractService.findTotalMoney(contract.getId()) != null)
//                contract.setTotalMoney(iContractService.findTotalMoney(contract.getId()));
//        }
//        if (!contracts.hasContent()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(contracts, HttpStatus.OK);
//    }

    @GetMapping("/create")
    public String createContract(Model model, Pageable pageable) {
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("employeeList", iEmployeeService.findAll(pageable));
        model.addAttribute("customerList", iCustomerService.findAll(pageable));
        model.addAttribute("facilityList", iFacilityService.findAll(pageable));
        model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
        return "/contract/con-create";
    }

    @PostMapping("/create")
    public String createContract(@ModelAttribute(value = "contractDto") @Valid ContractDto contractDto,
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

    @PostMapping("/createDetail")
    public String createContractDetail(@ModelAttribute(value = "contractDetailDto") @Valid ContractDetailDto contractDetailDto,
                                       BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                       Model model, Pageable pageable) {
        new ContractDetailDto().validate(contractDetailDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
//            model.addAttribute("contractList", iContractService.findAll(pageable));
            return "/contract/con-list";
        }

        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);

        iContractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/contract";
    }
}
