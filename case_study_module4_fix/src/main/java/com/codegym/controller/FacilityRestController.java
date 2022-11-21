package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.dto.FacilityDto;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import com.codegym.service.IFacilityService;
import com.codegym.service.IFacilityTypeService;
import com.codegym.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/facilityRest")
@CrossOrigin(origins = "*")
public class FacilityRestController {
    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("")
    public ResponseEntity<Page<Facility>> findAllFacility(Pageable pageable) {
        Page<Facility> facilityPage = this.iFacilityService.findAll(pageable);
        if (facilityPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(facilityPage, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facility> findById(@PathVariable Integer id) {
        Facility facility = this.iFacilityService.findById(id);
        return new ResponseEntity<>(facility, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createFacility(@Valid @RequestBody FacilityDto facilityDto, BindingResult bindingResult) {
        new FacilityDto().validate(facilityDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        iFacilityService.save(facility);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/facilityType")
    public ResponseEntity<List<FacilityType>> getAllFacilityType(){
        List<FacilityType> facilityTypes = this.iFacilityTypeService.findAll();
        return new ResponseEntity<>(facilityTypes,HttpStatus.OK);
    }

    @GetMapping("/rentType")
    public ResponseEntity<List<RentType>> getAllRentType(){
        List<RentType> rentTypes = this.iRentTypeService.findAll();
        return new ResponseEntity<>(rentTypes,HttpStatus.OK);
    }

}
