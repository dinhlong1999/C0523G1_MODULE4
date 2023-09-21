package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogService  {
    List<Blog> findAll();
    Blog findById(long id);
    void save(Blog blog);
    void delete(long id);

}
