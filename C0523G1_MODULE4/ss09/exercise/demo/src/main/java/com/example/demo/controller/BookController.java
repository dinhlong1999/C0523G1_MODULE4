package com.example.demo.controller;

import com.example.demo.model.Bill;
import com.example.demo.model.Book;
import com.example.demo.service.IBillService;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/bookstore")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBillService billService;


    @GetMapping("")
    public String showList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "index";
    }

    @GetMapping("/detail")
    public String detailBook(@RequestParam int id, Model model) {
        Book book = bookService.findById(id);
        if (book.getQuantity() == 0) {
            return "errors";
        }
        model.addAttribute("book", book);
        return "detail";
    }

    @GetMapping("/rent")
    public String showFormRent(@RequestParam int id, Model model) {
        Book book = bookService.findById(id);

        model.addAttribute("book", book);
        model.addAttribute("bill", new Bill());
        return "formRent";
    }
    @PostMapping("/save/bill")
    public String saveBill(@RequestParam int bookId, @ModelAttribute Bill bill, Model model){
        int randomNumber = (int) (Math.random() * 90000) + 10000;
        bill.setCode(randomNumber);
        Book book = bookService.findById(bookId);
        bill.setBook(book);
        billService.save(bill);
        book.setQuantity( book.getQuantity() - 1);
        bookService.save(book);
        model.addAttribute("bill",bill);
        return "bill";
    }
    @PostMapping("/give")
    public String showFormGiveBook(@RequestParam int code, RedirectAttributes requestAttribute, Model model){
        Bill bill = billService.getBillByCode(code);
        if (bill == null){
            requestAttribute.addFlashAttribute("message","Mã không đúng vui lòng nhập lại");
            return "redirect:/bookstore";
        }
        model.addAttribute("bill",bill);
        return "giveBook";
    }
    @PostMapping("/give/book")
    public String giveBook(@ModelAttribute("bill") Bill bill, RedirectAttributes redirectAttributes){
        bill.setStatus(1);
        billService.save(bill);
        Book book = bookService.findById(bill.getBook().getId());
        book.setQuantity(book.getQuantity() + bill.getQuantity());
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message","Trả Thành công");
        return "redirect:/bookstore";
    }



}


