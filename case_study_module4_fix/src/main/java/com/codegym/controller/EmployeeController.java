package com.codegym.controller;

import com.codegym.service.*;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IEducationService iEducationService;

    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showEmployee(Model model, @RequestParam(defaultValue = "") String name,
                               @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC)
                                       Pageable pageable) {

        model.addAttribute("employeeList", iEmployeeService.findAllByName(pageable, name));
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationList", iEducationService.findAll());
        model.addAttribute("userList", iUserService.findAll());
        model.addAttribute("name", name);
        return "/employee/emp-list";
    }

    @GetMapping("/edit")
    public String showEditEmployee(Model model, @RequestParam Integer id) {
        model.addAttribute("employeeEdit", iEmployeeService.findById(id));
        model.addAttribute("edit", "edit");
        return ("/employee/emp-list");
    }


}
