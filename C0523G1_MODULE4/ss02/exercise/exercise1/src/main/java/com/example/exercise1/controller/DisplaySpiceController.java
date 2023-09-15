package com.example.exercise1.controller;

import com.example.exercise1.service.IDisplaySpiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DisplaySpiceController {
    @Autowired
    private IDisplaySpiceService displaySpiceService;

    @GetMapping("/")
    public String showHome(){
        return "index";
    }
    @PostMapping("/showList")
    public String showList(@RequestParam("spice") String[] list, Model model){
        displaySpiceService.addSpice(list);
        List<String> list1 = displaySpiceService.showList();
        model.addAttribute("list1",list1);
        return "list";

    }
}
