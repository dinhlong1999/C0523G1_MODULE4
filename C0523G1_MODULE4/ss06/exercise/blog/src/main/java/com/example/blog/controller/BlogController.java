package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showList(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList",blogList);
        return "index";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blog.setDate(LocalDate.now());
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","Save success");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/view")
    public String showDetail(@PathVariable long id, Model model ){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "view";
    }
    @GetMapping("/{id}/edit")
    public String showFormEdit(@PathVariable long id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "edit";
    }
    @PostMapping("/edit")
    public String editBlog(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","Update success");
        return "redirect:/blog";
    }
    @PostMapping("/delete")
    public String deleteBlog(@RequestParam long id ,RedirectAttributes redirectAttributes){
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("message","Delete success");
        return "redirect:/blog";
    }
}
