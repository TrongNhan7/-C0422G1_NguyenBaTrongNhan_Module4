package com.codegym.controller;

import com.codegym.dto.TradeDto;
import com.codegym.model.Trade;
import com.codegym.service.ICustomerService;
import com.codegym.service.ITradeService;
import com.codegym.service.ITypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TradeController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ITypeService iTypeService;

    @Autowired
    private ITradeService iTradeService;

    @GetMapping("")
    public String showTrade(Model model, @RequestParam(defaultValue = "") String id,
                            @PageableDefault(size = 5)
                                    Pageable pageable) {

        model.addAttribute("tradeList", iTradeService.findAllByName(pageable,id));
        model.addAttribute("typeServiceList", iTypeService.findAll());
        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("id", id);
        return "/list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam String id, Model model) {
        model.addAttribute("trade", iTradeService.findByIdTrade(id));
        return "/detail";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("tradeDto", new TradeDto());
        model.addAttribute("typeServiceList", iTypeService.findAll());
        model.addAttribute("customerList", iCustomerService.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute(value = "tradeDto") @Valid TradeDto tradeDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                 Model model) {
        new TradeDto().validate(tradeDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("typeServiceList", iTypeService.findAll());
            model.addAttribute("customerList", iCustomerService.findAll());
            return "/create";
        }

        Trade trade = new Trade();
        BeanUtils.copyProperties(tradeDto, trade);

        iTradeService.save(trade);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/";
    }
}
