package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

//    @GetMapping("")
//    public String showList(Model model){
//        List<Blog> blogList = blogService.findAll();
//        model.addAttribute("blogList",blogList);
//        return "index";
//    }
//    @GetMapping("")
//    public ModelAndView showList(@PageableDefault(value = 0, size = 2) Pageable pageable){
//        Page<Blog> blogList = blogService.findByPage(pageable);
//        ModelAndView modelAndView = new ModelAndView("index","blogList",blogList);
//        return modelAndView;
//    }
    @GetMapping("")
    public ModelAndView showList(@RequestParam(defaultValue = "0", required = false) int page,
                                 @RequestParam(defaultValue = "", required = false) String nameSearch){
        Pageable pageable = PageRequest.of(page,2, Sort.by("date").ascending());
        Page<Blog> blogList = blogService.findBlogByNameContaining(pageable,nameSearch);
        ModelAndView modelAndView = new ModelAndView("index","blogList",blogList);
        modelAndView.addObject("nameSearch", nameSearch);
        List<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }



    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "create";
    }
    @GetMapping("/category")
    public String showCategoryList(Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "category";
    }

    @GetMapping("/category/create")
    public String showFormCreateCategory(Model model){
        model.addAttribute("category", new Category());
        return "category-create";
    }
    @PostMapping("/category/create")
    public String saveCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.addCategory(category);
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
        return "redirect:/blog/category";
    }
    @GetMapping("{id}/category/detail")
    public String showCategoryDetail(@PathVariable int id, Model model){
        List<Blog> blogList = blogService.searchBlogByCategory_Id(id);
        model.addAttribute("blogList",blogList);
        return "category-detail";
    }
    @PostMapping("/category/delete")
    public String deleteCategory(@RequestParam int id , RedirectAttributes redirectAttributes){
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("message","Xoá thành công");
        return "redirect:/blog/category";
    }

    @GetMapping("{id}/category/edit")
    public String showFormEditCategory(@PathVariable int id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "category-edit";
    }
    @PostMapping ("/category/edit")
    public String editCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.addCategory(category);
        redirectAttributes.addFlashAttribute("message"," Sửa thành công");
        return "redirect:/blog/category";

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
