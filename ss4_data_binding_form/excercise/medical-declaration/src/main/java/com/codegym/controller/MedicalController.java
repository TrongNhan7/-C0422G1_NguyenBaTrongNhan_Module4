package com.codegym.controller;

import com.codegym.model.Medical;
import com.codegym.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MedicalController {

    @Autowired
    private IMedicalService iMedicalService;

    @GetMapping("/")
    public String showForm(ModelMap modelMap) {
        modelMap.addAttribute("medical", new Medical());
        modelMap.addAttribute("listBirthYear", iMedicalService.listBirthYear());
        modelMap.addAttribute("listGender", iMedicalService.listGender());
        modelMap.addAttribute("listNation", iMedicalService.listNation());
        modelMap.addAttribute("listTravelInformation", iMedicalService.listTravelInformation());
        modelMap.addAttribute("listYear", iMedicalService.listYear());
        modelMap.addAttribute("listMonth", iMedicalService.listMonth());
        modelMap.addAttribute("listDay", iMedicalService.listDay());
        modelMap.addAttribute("listYearEnd", iMedicalService.listYearEnd());
        modelMap.addAttribute("listMonthEnd", iMedicalService.listMonthEnd());
        modelMap.addAttribute("listDayEnd", iMedicalService.listDayEnd());
        return "/create";
    }

    @GetMapping("/showList")
    public String getAllMedical(Model model) {
        List<Medical> medicalList = iMedicalService.findAll();
        model.addAttribute("medicalList", medicalList);
        return "/list";
    }


    @PostMapping("/editMedical")
    public String editMedical(@ModelAttribute("medical") Medical medical, RedirectAttributes redirectAttributes) {
        iMedicalService.editMedical(medical);
        redirectAttributes.addFlashAttribute("mess", "Edit thành công");
        return "redirect:/showList";
    }

    @GetMapping("/deleteMedical/{idCard}")
    public String deleteMedical(@PathVariable String idCard, Model model) {
        iMedicalService.deleteMedical(idCard);
        return "redirect:/showList";
    }

    @GetMapping("/showEditMedical/{idCard}")
    public String showEditMedical(@PathVariable String idCard, ModelMap modelMap) {
        Medical medicalEdit = iMedicalService.findByIdCard(idCard);
        modelMap.addAttribute("medical", new Medical());
        modelMap.addAttribute("medicalEdit", medicalEdit);
        modelMap.addAttribute("listBirthYear", iMedicalService.listBirthYear());
        modelMap.addAttribute("listGender", iMedicalService.listGender());
        modelMap.addAttribute("listNation", iMedicalService.listNation());
        modelMap.addAttribute("listTravelInformation", iMedicalService.listTravelInformation());
        modelMap.addAttribute("listYear", iMedicalService.listYear());
        modelMap.addAttribute("listMonth", iMedicalService.listMonth());
        modelMap.addAttribute("listDay", iMedicalService.listDay());
        modelMap.addAttribute("listYearEnd", iMedicalService.listYearEnd());
        modelMap.addAttribute("listMonthEnd", iMedicalService.listMonthEnd());
        modelMap.addAttribute("listDayEnd", iMedicalService.listDayEnd());
        return "/edit";
    }

    @PostMapping("/addMedical")
    public String addMedical(@ModelAttribute("medical") Medical medical, RedirectAttributes redirectAttributes) {
        iMedicalService.addMedical(medical);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/showList";
    }
}
