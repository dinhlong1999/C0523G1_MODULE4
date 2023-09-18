package com.example.practice3.controller;

import com.example.practice3.model.Product;
import com.example.practice3.service.IProductService;
import com.example.practice3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private  IProductService productService;

    @GetMapping("")
    public String index(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "index";
    }

}
