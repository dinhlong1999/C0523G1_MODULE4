package com.example.cart.controller;

import com.example.cart.dto.CartDTO;
import com.example.cart.dto.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping
    public ModelAndView showCart(@SessionAttribute(value = "cart",required = false)CartDTO cartDTO){
        return new ModelAndView("cart","cart",cartDTO);
    }




}
