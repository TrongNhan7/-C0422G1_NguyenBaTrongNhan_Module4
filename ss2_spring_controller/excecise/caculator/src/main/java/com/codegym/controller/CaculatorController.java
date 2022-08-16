package com.codegym.controller;

import com.codegym.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {

    @Autowired
    private ICaculatorService iCaculatorService;

    @GetMapping("/")
    public String calculator() {
        return "/index";
    }

    @PostMapping("/caculator")
    public String result(@RequestParam("number1") double number1, @RequestParam double number2,
                         @RequestParam char operator, Model model) {
        double result = iCaculatorService.calculator(number1, number2, operator);
        model.addAttribute("result", result);
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        return "/index";
    }

}


