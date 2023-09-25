package com.example.exercise.controller;

import com.example.exercise.model.User;
import com.example.exercise.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public String formLogin(Model model){
        model.addAttribute("user", new User());
        return "form_login";
    }

    @PostMapping("/login/save")
    public String login(@Validated @ModelAttribute User user,  BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "form_login";
        }
        userService.save(user);
        model.addAttribute("user",user);
        model.addAttribute("message","login success");

        return "view";
    }

}
