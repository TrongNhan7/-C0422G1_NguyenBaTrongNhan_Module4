package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
  private   IDictionaryService dictionaryRepository;

    @GetMapping("/")
    public String word() {
        return "/list";
    }

    @PostMapping("/dictionary")
    public String vNSub(@RequestParam String word, Model model) {
        String result = dictionaryRepository.dictionary(word);
        if (result == null) {
            model.addAttribute("result", "Not found");
            model.addAttribute("keyWord", word);
        } else {
            model.addAttribute("result", result);
            model.addAttribute("keyWord", word);
        }
        return "/list";
    }
}
