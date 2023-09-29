package com.example.exercise.controller;

import com.example.exercise.model.Category;
import com.example.exercise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;


    //Xem danh sách các category
    @GetMapping
    public ResponseEntity<List<Category>> showListCategory(){
        List<Category> categoryList = categoryService.findAll();
        if (categoryList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
}
