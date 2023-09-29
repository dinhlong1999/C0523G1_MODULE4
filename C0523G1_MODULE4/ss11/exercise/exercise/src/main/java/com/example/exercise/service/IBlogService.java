package com.example.exercise.service;

import com.example.exercise.model.Blog;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    List<Blog> findBlogByCategoryId(Integer id);
}
