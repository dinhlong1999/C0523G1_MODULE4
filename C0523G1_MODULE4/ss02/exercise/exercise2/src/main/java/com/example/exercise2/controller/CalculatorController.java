package com.example.exercise2.controller;

import com.example.exercise2.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @RequestMapping("/")
    public String showCalculator(){
        return "result";
    }
    @PostMapping("/calculator")
    public String calculator(@RequestParam float firstNumber, float secondNumber, String calculation, Model model){
        float result = calculatorService.calculator(firstNumber,secondNumber,calculation);
        model.addAttribute("result",result);
        return "result";
    }

}
