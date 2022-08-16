package com.codegym.controller;

import com.codegym.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SandwichController {

    @Autowired
    private ISandwichService iSandwichService;

    @GetMapping("/")
    public String showListCondiments(Model model) {
        List<String> condimentsList = iSandwichService.findAllCondiments();
        model.addAttribute("listCondiment", condimentsList);
        return "/index";
    }

    @GetMapping("/sandwich")
    public String condiments(@RequestParam(value = "condiments", required = false) List<String> condiments, Model model) {
        if (condiments == null) {
            model.addAttribute("mess", "Bạn phải chọn 1 gia vị");
        } else {
            model.addAttribute("listCondiment", condiments);
        }
        return "/choose";
    }
}
