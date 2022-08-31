package com.codegym.controller;


import com.codegym.model.facility.FacilityType;
import com.codegym.service.IFacilityService;
import com.codegym.service.IFacilityTypeService;
import com.codegym.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("")
    public String showFacility(Model model, @RequestParam(defaultValue = "") String keyword,
                               @PageableDefault(size = 5, sort = "nameService", direction = Sort.Direction.ASC)
                               @RequestParam(required = false, defaultValue = "0") Integer typeId,
                               Pageable pageable) {
        FacilityType facilityType = iFacilityTypeService.findById(typeId);
        model.addAttribute("facilityList", iFacilityService.findAllByName(pageable, keyword, facilityType));
        model.addAttribute("facilityType", iFacilityTypeService.findAll());
        model.addAttribute("rentType", iRentTypeService.findAll());
        return "/facility/fac-list";
    }


}
