package com.example.practice2.controller;

import com.example.practice2.model.Login;
import com.example.practice2.model.User;
import com.example.practice2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private  IUserService userService;

    @ModelAttribute("login")
    public Login login(){
        return new Login();
    }

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("login",new Login());
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = userService.checkLogin(login);
        ModelAndView modelAndView;
        if (user == null){
            modelAndView = new ModelAndView("error");
        }else {
            modelAndView = new ModelAndView("user");
            modelAndView.addObject("user",user);
        }

        return modelAndView;
    }
}
