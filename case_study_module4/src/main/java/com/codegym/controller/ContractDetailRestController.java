package com.codegym.controller;


import com.codegym.dto.ContractDetailDto;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.IAttachFacilityService;
import com.codegym.service.IContractDetailService;
import com.codegym.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/contract-detail")
public class ContractDetailRestController {

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private IContractService iContractService;

//    @GetMapping
//    public ResponseEntity<Page<Contract>> allContract(Model model, @RequestParam(defaultValue = "") String keyword,
//                                        @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC)
//                                        Pageable pageable) {
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

    @PostMapping("/create")
    public ResponseEntity<ContractDetailDto> createContractDetail(@RequestBody @Valid ContractDetailDto contractDetailDto,
                                                                     BindingResult bindingResult, Model model, Pageable pageable) {
        new ContractDetailDto().validate(contractDetailDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(contractDetailDto, HttpStatus.BAD_REQUEST);
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        iContractDetailService.save(contractDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AttachFacility>> allAttachFacility(@PathVariable Integer id) {
        List<AttachFacility> attachFacilities = iAttachFacilityService.findAllByIdContract(id);
        if (attachFacilities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilities, HttpStatus.OK);
    }
}
