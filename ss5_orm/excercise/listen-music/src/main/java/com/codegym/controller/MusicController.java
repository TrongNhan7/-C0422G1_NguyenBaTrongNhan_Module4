package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {

    @Autowired
    IMusicService iMusicService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("musicList", iMusicService.findAll());
        return ("/list");
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("music", new Music());
        return "/create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute(value = "music") Music product, RedirectAttributes redirectAttributes) {
        iMusicService.addProduct(product);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Music product, RedirectAttributes redirectAttributes) {
        iMusicService.edit(product);
        redirectAttributes.addFlashAttribute("mess", "Edit thành công");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Delete thành công");
        iMusicService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "/detail";
    }

}
