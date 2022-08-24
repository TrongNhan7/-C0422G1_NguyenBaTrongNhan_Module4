package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;


    @GetMapping("/")
    public String findByTitle(Model model, @RequestParam(defaultValue = "") String title) {
        model.addAttribute("blogList", iBlogService.findByTitle(title));
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Edit thành công");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Delete thành công");
        iBlogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/detail";
    }
}
