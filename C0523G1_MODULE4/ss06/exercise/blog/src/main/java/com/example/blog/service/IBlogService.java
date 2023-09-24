package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogService  {
    List<Blog> findAll();
    Blog findById(long id);
    void save(Blog blog);
    void delete(long id);
    Page<Blog> findByPage(Pageable pageable);
    Page<Blog> findBlogByNameContaining(Pageable pageable, String name);
    List<Blog> searchBlogByCategory_Id(int id);
}
