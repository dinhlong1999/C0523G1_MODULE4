package com.example.productmanagerment.controller;

import com.example.productmanagerment.model.Product;
import com.example.productmanagerment.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String getAll(Model model){
        List<Product> productList = productService.getAll();
        model.addAttribute("productList",productList);
        return "index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        product.setId((int)(Math.random()*1000));
        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("message","CREATE SUCCESS");
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model){
        int index = productService.findId(id);
        Product product = productService.searchById(index);
        model.addAttribute("product",product);
        return "update";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        int index = productService.findId(product.getId());
        productService.updateProduct(index,product);
        redirectAttributes.addFlashAttribute("message","EDIT SUCCESS");
        return "redirect:/product";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,Model model){
        int index = productService.findId(id);
        Product product = productService.searchById(index);
        model.addAttribute("product",product);
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        int index = productService.findId(product.getId());
        productService.deleteProduct(index);
        redirectAttributes.addFlashAttribute("message","DELETE SUCCESS");
        return "redirect:/product";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model ){
        int index = productService.findId(id);
        Product product = productService.searchById(index);
        model.addAttribute("product",product);
        return "view";
    }
}
