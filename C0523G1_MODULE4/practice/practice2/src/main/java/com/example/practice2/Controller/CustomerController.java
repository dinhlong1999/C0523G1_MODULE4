package com.example.practice2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
    
    @GetMapping("/customer")
    public String showList(HttpServletRequest request){
        List<>
    }
}
