package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("bookList", iBookService.findAll());
        return "/list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam int id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "/detail";
    }

    @GetMapping("/borrow")
    public String borrowBook(@RequestParam Integer id, RedirectAttributes redirectAttributes)
            throws Exception {
        Book book = iBookService.findById(id);

        if (book.getRemaining() == 0) {
            throw new Exception();
        }

        iBookService.borrowBook(id);
        redirectAttributes.addFlashAttribute("mess", "Mượn thành công");
        return "redirect:/";
    }

    @GetMapping("/backBook")
    public String backBook(@RequestParam Integer id, RedirectAttributes redirectAttributes)
            throws Exception {
        Book book = iBookService.findById(id);

        if (book.getRemaining() >= book.getTotalBook()) {
            throw new Exception();
        }
        iBookService.backBook(id);
        redirectAttributes.addFlashAttribute("mess", "Trả thành công");
        return "redirect:/";
    }

    @ExceptionHandler(value = Exception.class)
    public String errors() {
        return "/errors";
    }
}
