package com.example.exercise2.controller;

import com.example.exercise2.service.DictionaryService;
import com.example.exercise2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping("/dictionary")
    public String dictionary(){
        return "result";
    }
    @PostMapping("/dictionary")
    public String dictionary(@RequestParam String text, Model model){
        String result = dictionaryService.dictionary(text);
        if (result != null){
            model.addAttribute("result",result);
        }else {
            model.addAttribute("message","NO FOUND");
        }
        return "result";
    }
}
