package com.codegym.controller;

import com.codegym.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {

    @Autowired
    private IService iService;

    @GetMapping("/")
    public String sandwich() {
        return "/index";
    }

    @GetMapping("/sandwich")
    public String condiments(@RequestParam(value = "condiments", required = false) String[] condiments, Model model) {
        String[] displayCondiment = iService.condiments(condiments);
        model.addAttribute("listCondiment", Arrays.toString(displayCondiment));
        return "/index";
    }
}
