package com.example.cart.controller;

import com.example.cart.dto.CartDTO;
import com.example.cart.dto.ProductDTO;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@SessionAttributes("cart")
@RequestMapping("/product")
public class ProductController {

    @ModelAttribute("cart")
    public CartDTO setCart(){
        return new CartDTO();
    }


    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "index";
    }

    @GetMapping("/detail")
    public String productDetail(@RequestParam int id, Model model, RedirectAttributes redirectAttributes){
        try {
            Product product = productService.findById(id);
            model.addAttribute("product", product);
        }catch (IllegalArgumentException ex){
            redirectAttributes.addFlashAttribute("message",ex.getMessage());
            return "redirect:/product";
        }

        return "detail";
    }
    @GetMapping("/addCart")
    public String addToCart(@RequestParam int id, @RequestParam String action, @SessionAttribute(value = "cart") CartDTO cartDTO, RedirectAttributes redirectAttributes){
        try {
            Product product = productService.findById(id);
            if (product != null || action.equals("show")){
                ProductDTO productDTO = new ProductDTO();
                BeanUtils.copyProperties(product,productDTO);
                cartDTO.addProduct(productDTO);
            }
        }catch (IllegalArgumentException ex){
            redirectAttributes.addFlashAttribute("message", ex.getMessage());
        }

//        if (action.equals("show")){
//            ProductDTO productDTO = new ProductDTO();
//            BeanUtils.copyProperties(product,productDTO);
//            cartDTO.addProduct(productDTO);
//
//        }
        return "redirect:/cart";
    }
    @GetMapping("/remove")
    public String remove(@RequestParam int id, @SessionAttribute(value = "cart") CartDTO cartDTO, RedirectAttributes redirectAttributes){
        try {
            Product product = productService.findById(id);
            if (product != null){
                ProductDTO productDTO = new ProductDTO();
                BeanUtils.copyProperties(product,productDTO);
                cartDTO.deleteProduct(productDTO);
            }
        }catch (IllegalArgumentException ex){
            redirectAttributes.addFlashAttribute("message",ex.getMessage());
        }

        return "redirect:/cart";
    }

}
