package com.codegym.controller;

import com.codegym.model.MailBox;
import com.codegym.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailBoxController {

    @Autowired
    private IMailBoxService iMailBoxService;

    @GetMapping("/")
    public String showForm(ModelMap modelMap) {
        modelMap.addAttribute("mailBox", new MailBox());
        modelMap.addAttribute("typeLanguages", iMailBoxService.listLanguages());
        modelMap.addAttribute("typePageSize", iMailBoxService.listLPageSize());
        return "/create";
    }

    @PostMapping("/addMailBox")
    public String addMailBox(@ModelAttribute("mailBox") MailBox mailBox, Model model) {
        iMailBoxService.addMailBox(mailBox);
        model.addAttribute("mailBox", iMailBoxService.findAll());
        return "/infor";
    }
}
