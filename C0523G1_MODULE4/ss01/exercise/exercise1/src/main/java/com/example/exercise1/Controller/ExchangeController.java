package com.example.exercise1.Controller;

import com.example.exercise1.Service.ExchangeService;
import com.example.exercise1.Service.IExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeController {
    @Autowired
    private IExchangeService exchangeService;

    @GetMapping("/exchange")
    public String exchange(){
        return "calculator";
    }
    @PostMapping ("/exchange/calculator")
    public String exchangeMoney(@RequestParam float money, Model model){
        float result = exchangeService.exchangeMoney(money);
        model.addAttribute("result",result);
        return "calculator";
    }
}
