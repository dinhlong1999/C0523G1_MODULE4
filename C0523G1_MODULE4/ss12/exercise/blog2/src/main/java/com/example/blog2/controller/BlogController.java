package com.example.blog2.controller;

import com.example.blog2.model.Blog;
import com.example.blog2.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin("*")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> getPage(@RequestParam(defaultValue = "0",required = false) int page){
        Pageable pageable = PageRequest.of(page,2);
        Page<Blog> blogPage = blogService.findAll(pageable);
        if (blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> getBlogByName(@RequestParam String name){
        List<Blog> blogList = blogService.findBlogByNameContaining(name);
            if (blogList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveBlog(@RequestBody Blog blog){
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        blogService.saveBlog(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
