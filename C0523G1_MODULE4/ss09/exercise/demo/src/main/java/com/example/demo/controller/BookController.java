package com.example.demo.controller;

import com.example.demo.model.Bill;
import com.example.demo.model.Book;
import com.example.demo.service.IBillService;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookStore")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBillService billService;


    @GetMapping("")
    public String showList(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList",bookList);
        return "index";
    }
    @GetMapping("/detail")
    public String detailBook(@RequestParam int id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        return "detail";
    }
    @GetMapping("/rent")
    public String showFormRent(@RequestParam int id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("bill", new Bill());
        return "formRent";
    }
    @PostMapping("/save/bill")
    public String saveBill(@ModelAttribute Bill bill,@RequestParam int bookId){
        bill.setCode((int)Math.random()*99999);
        bill.setQuantity(1);
        bill.setBook(bookService.findById(bookId));

        billService.save(bill);
        return "redirect:/bookStore";

    }

}
