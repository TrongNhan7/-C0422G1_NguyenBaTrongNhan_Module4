package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConversionController {

    @GetMapping("/")
    public String home(){
        return "/home";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam double usd, double rate, Model model){
        double result = usd*rate;
        model.addAttribute("result",result);
        model.addAttribute("usd",usd);
        model.addAttribute("rate",rate);
        return "/home";
    }
}
