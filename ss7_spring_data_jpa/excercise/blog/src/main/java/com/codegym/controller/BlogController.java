package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/")
    public String findByTitle(Model model, @RequestParam(defaultValue = "") String title,
                              @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("blogList", iBlogService.findByTitle(title, pageable));
        return "/listBlock";
    }

    @GetMapping("/create")
    public String showCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("listCategory", iCategoryService.findByNameCategory());
        return "/create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEditBLog(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("listCategory", iCategoryService.findByNameCategory());
        return "/edit";
    }

    @PostMapping("/edit")
    public String EditBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
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
