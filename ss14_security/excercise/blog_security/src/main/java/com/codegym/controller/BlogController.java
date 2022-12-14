package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@RequestMapping("/blog")
@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String findByTitle(Model model, @RequestParam(defaultValue = "") String title,
                              @RequestParam(defaultValue = "0") Integer id,
                              @PageableDefault(size = 5, sort = "date_create", direction = Sort.Direction.ASC)
                                      Pageable pageable, Principal principal) {
        model.addAttribute("blogList", iBlogService.findByTitleAndCategory(title, id, pageable));
        model.addAttribute("listCategory", iCategoryService.findCategory());
        model.addAttribute("title", title);
        model.addAttribute("id", id);
        User user = (User) ((Authentication) principal).getPrincipal();
        for (GrantedAuthority a: user.getAuthorities()){
            if (a.getAuthority().equals("ROLE_ADMIN")) {
                model.addAttribute("security", "ADMIN");
            }
        }
        return "listBlog";
    }

    @GetMapping("/create")
    public String showCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("listCategory", iCategoryService.findCategory());
        return "/create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Th??m m???i th??nh c??ng");
        return "redirect:/blog/";
    }

    @GetMapping("/edit")
    public String showEditBLog(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("listCategory", iCategoryService.findCategory());
        return "/edit";
    }

    @PostMapping("/edit")
    public String EditBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Edit th??nh c??ng");
        return "redirect:/blog/";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Delete th??nh c??ng");
        iBlogService.delete(id);
        return "redirect:/blog/";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/detail";
    }
}
