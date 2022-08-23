package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String showList(Model model, String name) {
        model.addAttribute("productList", iProductService.findByName(name));
        return ("/list");
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute(value = "product") Product product, RedirectAttributes redirectAttributes) {
        iProductService.addProduct(product);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.edit(product);
        redirectAttributes.addFlashAttribute("mess", "Edit thành công");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Delete thành công");
        iProductService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/detail";
    }

}
