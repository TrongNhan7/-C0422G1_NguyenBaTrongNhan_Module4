package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("userList", iUserService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/create";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute(value = "userDto") @Valid UserDto userDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/create";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        iUserService.save(user);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/";
    }
}
