package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.ICartService;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes("carts")
public class ShoppingCartController {

    @Autowired
    private ICartService iCartService;

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("carts")
    public Map<Integer, Cart> createCart() {
        return new HashMap<>();
    }


    @GetMapping("/shopping-cart")
    public String showCart(Model model, @ModelAttribute(value = "carts") Map<Integer, Cart> carts) {
        model.addAttribute("cartList", carts);
        model.addAttribute("total", iCartService.getAmount(carts));
        model.addAttribute("counts", iCartService.getCount(carts));
        return "/cart";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable Integer id, @ModelAttribute(value = "carts") Map<Integer, Cart> carts, @RequestParam("action") String action) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (productOptional.get() != null && action.equals("show")) {
            Cart cartNew = new Cart();
            BeanUtils.copyProperties(productOptional.get(), cartNew);
            cartNew.setQuantity(1);
            iCartService.add(carts, cartNew);
            return "redirect:/shopping-cart";
        }
        Cart cartNew = new Cart();
        BeanUtils.copyProperties(productOptional.get(), cartNew);
        cartNew.setQuantity(1);
        iCartService.add(carts, cartNew);
        return "redirect:/shop";
    }

    @GetMapping("/decreate/{id}")
    public String decreate(@PathVariable Integer id, @ModelAttribute(value = "carts") Map<Integer, Cart> carts, @RequestParam("action") String action) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (productOptional.get() != null && action.equals("show")) {
            Cart cartNew = new Cart();
            BeanUtils.copyProperties(productOptional.get(), cartNew);
            iCartService.decreate(carts, cartNew);
            return "redirect:/shopping-cart";
        }
        Cart cartNew = new Cart();
        BeanUtils.copyProperties(productOptional.get(), cartNew);
        iCartService.decreate(carts, cartNew);
        return "redirect:/shop";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute(value = "carts") Map<Integer, Cart> carts, @RequestParam(value = "id") Integer id) {
        iCartService.remove(carts, id);
        return "redirect:/shopping-cart";
    }
}