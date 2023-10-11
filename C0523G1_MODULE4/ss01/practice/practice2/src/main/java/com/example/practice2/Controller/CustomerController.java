package com.example.practice2.Controller;

import com.example.practice2.Service.ICustomerService;
import com.example.practice2.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")
    public String showList(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList",customerList);
        return "/list";
    }
    @GetMapping("/create")
    public String showFormCreate(){
        return "showFormCreate";
    }
    @PostMapping("/create")
    public String addCustomer(@RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam String address, RedirectAttributes redirectAttributes){
        customerService.addCustomer(new Customer(id,name,email,address));
        redirectAttributes.addFlashAttribute("message","create success");
        return "redirect:/customer/list";
    }
}
