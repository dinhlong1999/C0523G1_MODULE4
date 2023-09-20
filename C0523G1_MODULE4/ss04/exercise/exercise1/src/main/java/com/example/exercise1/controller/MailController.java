package com.example.exercise1.controller;

import com.example.exercise1.model.Mail;
import com.example.exercise1.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MailController {

    @Autowired
    private IMailService mailService;

    @ModelAttribute("languagesList")
    public String[] getLanguages(){
        return new String[]{"English","Vietnamese","Japanese","Chinese"};
    }

    @ModelAttribute("pageSizeList")
    public int[] getPageSize(){
        return new int[]{5,10,15,25,50,100};
    }



    @GetMapping("/showForm")
    public String showList(Model model){
        List<Mail> mailList = mailService.getAll();
        model.addAttribute("mailList",mailList);
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model){
        Mail mail = mailService.searchMail(id);
        model.addAttribute("mail",mail);
        return "update";
    }
    @PostMapping("/edit")
    public String editConfig(@ModelAttribute Mail mail, RedirectAttributes redirectAttributes){
//        int index = mailService.findIndex(mail.getId());
        mailService.editConfig(mail);
        redirectAttributes.addFlashAttribute("message","Edit success");
        return "redirect:/showForm";
    }

}
