package com.codegym.controller;


import com.codegym.dto.CustomerDto;
import com.codegym.dto.CustomerTypeDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public String showCustomer(Model model, @RequestParam(defaultValue = "") String keyword,
                               @PageableDefault(size = 5, sort = "customer_name", direction = Sort.Direction.ASC)
                                       Pageable pageable) {
        model.addAttribute("typeList", iCustomerTypeService.findAll());
        model.addAttribute("customerList", iCustomerService.findAllByName(keyword, pageable));
        model.addAttribute("keyword", keyword);
        return "/customer/cus-list";
    }

    @GetMapping(value = "/create")
    public String showCreateCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("typeList", iCustomerTypeService.findAll());
        return "/customer/cus-create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute(value = "customerDto") @Valid CustomerDto customerDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                 Model model) {
        new CustomerDto().validate(customerDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("typeList", iCustomerTypeService.findAll());
            return "/customer/cus-create";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        CustomerType customerType = new CustomerType();
        customerType.setId(customerDto.getCustomerType().getId());
        customer.setCustomerType(customerType);

        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/customer";
    }

    @GetMapping("/edit")
    public String showEditCustomer(@RequestParam Integer id, Model model) {
        Customer customer = iCustomerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setId(customer.getCustomerType().getId());
        customerDto.setCustomerType(customerTypeDto);

        model.addAttribute("customerDto", customerDto);
        model.addAttribute("typeList", iCustomerTypeService.findAll());
        return "/customer/cus-edit";
    }

    @PostMapping("/edit")
    public String EditCustomer(@ModelAttribute(value = "customerDto") @Valid CustomerDto customerDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {

        new CustomerDto().validate(customerDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("typeList", iCustomerTypeService.findAll());
            return "customer/cus-edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        CustomerType customerType = new CustomerType();
        customerType.setId(customerDto.getCustomerType().getId());
        customer.setCustomerType(customerType);

        redirectAttributes.addFlashAttribute("msg", "Edit thành công thành !");
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Delete thành công");
        iCustomerService.deleteById(id);
        return "redirect:/customer";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/customer/cus-detail";
    }

}
