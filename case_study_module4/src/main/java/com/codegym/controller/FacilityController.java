package com.codegym.controller;


import com.codegym.dto.CustomerDto;
import com.codegym.dto.CustomerTypeDto;
import com.codegym.dto.FacilityDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import com.codegym.service.IFacilityService;
import com.codegym.service.IFacilityTypeService;
import com.codegym.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
                               @RequestParam(required = false, defaultValue = "0") Integer typeId,
                               @PageableDefault(size = 2, sort = "nameService", direction = Sort.Direction.ASC)
                                       Pageable pageable) {
        FacilityType facilityType = iFacilityTypeService.findById(typeId);
        model.addAttribute("facilityList", iFacilityService.findAllByName(pageable, keyword, facilityType));
        model.addAttribute("facilityType", iFacilityTypeService.findAll());
        model.addAttribute("rentType", iRentTypeService.findAll());
        model.addAttribute("keyword", keyword);
        return "/facility/fac-list";
    }

    @GetMapping(value = "/create")
    public String showCreateFacility(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("facilityType", iFacilityTypeService.findAll());
        model.addAttribute("rentType", iRentTypeService.findAll());
        return "/facility/fac-create";
    }

    @PostMapping("/create")
    public String createFacility(@ModelAttribute(value = "facilityDto") @Valid FacilityDto facilityDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                 Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityType", iFacilityTypeService.findAll());
            model.addAttribute("rentType", iRentTypeService.findAll());
            return "/facility/fac-create";
        }

        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);

        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Th??m m???i th??nh c??ng");
        return "redirect:/facility";
    }

    @GetMapping("/edit")
    public String showEditFacility(@RequestParam Integer id, Model model) {
        Facility facility = iFacilityService.findById(id);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility, facilityDto);

        model.addAttribute("facilityDto", facilityDto);
        model.addAttribute("facilityType", iFacilityTypeService.findAll());
        model.addAttribute("rentType", iRentTypeService.findAll());
        return "/facility/fac-edit";
    }

    @PostMapping("/edit")
    public String EditFacility(@ModelAttribute(value = "facilityDto") @Valid FacilityDto facilityDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {

        new FacilityDto().validate(facilityDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityType", iFacilityTypeService.findAll());
            model.addAttribute("rentType", iRentTypeService.findAll());
            return "facility/fac-edit";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);

        redirectAttributes.addFlashAttribute("msg", "Edit th??nh c??ng th??nh !");
        iFacilityService.save(facility);
        return "redirect:/facility";
    }

    @GetMapping("/delete")
    public String deleteFAcility(@RequestParam(value = "idFacility") Integer id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Delete th??nh c??ng");
        iFacilityService.deleteById(id);
        return "redirect:/facility";
    }

}
