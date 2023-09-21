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
        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("message","CREATE SUCCESS");
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model){
        Product product = productService.searchById(id);
        model.addAttribute("product",product);
        return "update";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        productService.updateProduct(product.getId(),product);
        redirectAttributes.addFlashAttribute("message","EDIT SUCCESS");
        return "redirect:/product";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes){
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message","DELETE SUCCESS");
        return "redirect:/product";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model ){
        Product product = productService.searchById(id);
        model.addAttribute("product",product);
        return "view";
    }
    @PostMapping("/search")
    public String search(@RequestParam String name,Model model){
        List<Product> product = productService.searchByName(name);
        model.addAttribute("product",product);
        return "search";
    }
}
