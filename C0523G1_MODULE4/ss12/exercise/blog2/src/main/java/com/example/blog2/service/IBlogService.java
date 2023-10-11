package com.example.blog2.service;

import com.example.blog2.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
   Page<Blog> findAll(Pageable pageable);

   List<Blog> findBlogByNameContaining(String name);

   void saveBlog(Blog blog);
}
