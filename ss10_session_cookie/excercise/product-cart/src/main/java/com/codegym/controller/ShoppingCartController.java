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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ShoppingCartController {

    @Autowired
    private ICartService iCartService;

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Map<Integer, Cart> cart() {
        return new HashMap<>();
    }


    @GetMapping("/shopping-cart")
    public String showCart(Model model, @SessionAttribute Map<Integer, Cart> cart) {
        model.addAttribute("cartList", cart);
        model.addAttribute("total", iCartService.getAmount(cart));
        model.addAttribute("counts", iCartService.getCount(cart));
        return "/cart";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable Integer id, @SessionAttribute Map<Integer, Cart> cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (productOptional.get() != null && action.equals("show")) {
            Cart cartNew = new Cart();
            BeanUtils.copyProperties(productOptional.get(), cartNew);
            iCartService.add(cart, cartNew);
            return "redirect:/shopping-cart";
        }
        Cart cartNew = new Cart();
        BeanUtils.copyProperties(productOptional.get(), cartNew);
        iCartService.add(cart, cartNew);
        return "redirect:/shop";
    }
}