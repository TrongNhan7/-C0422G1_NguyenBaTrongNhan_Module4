package com.codegym.controller;

import com.codegym.model.contract.AttachFacility;
import com.codegym.model.facility.Facility;
import com.codegym.service.IAttachFacilityService;
import com.codegym.service.IContractService;
import com.codegym.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contractRest")
public class ContractRestController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @GetMapping("/{id}")
    public ResponseEntity<Facility> findByIdFacility(@PathVariable Integer id) {
        Facility facility = iFacilityService.findById(id);
        if (facility == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(facility, HttpStatus.OK);
    }

    @GetMapping("/findAttach")
    public ResponseEntity<AttachFacility> findByIdAttach(@RequestParam String id) {
        Integer idAttachFacility = Integer.parseInt(id);
        System.out.println(idAttachFacility);
        AttachFacility attachFacility = iAttachFacilityService.findById(idAttachFacility);
        if (attachFacility == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacility, HttpStatus.OK);
    }
}
