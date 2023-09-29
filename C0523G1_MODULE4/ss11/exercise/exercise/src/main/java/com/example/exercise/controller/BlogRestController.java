package com.example.exercise.controller;

import com.example.exercise.model.Blog;
import com.example.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog")
public class BlogRestController {

    @Autowired
    private IBlogService blogService;


    //Xem danh sách các bài viết
    @GetMapping
    public ResponseEntity<List<Blog>> showListBlog(Model model){
        List<Blog> blogList = blogService.findAll();
        if (blogList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    //Xem danh sách các bài viết của một category
    @GetMapping("/{id}")
    public ResponseEntity<Blog> showBlog(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    //Xem chi tiết một bài viết
    @GetMapping("/detail/{id}")
    public ResponseEntity<List<Blog>> showBlogByCategoryId(@PathVariable int id){
        List<Blog> blogList = blogService.findBlogByCategoryId(id);
        if (blogList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

}
