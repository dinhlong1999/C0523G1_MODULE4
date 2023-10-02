package com.example.blog2.service;

import com.example.blog2.model.Blog;
import com.example.blog2.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService  implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
     public List<Blog> findBlogByNameContaining(String name){
        return blogRepository.findBlogByNameContaining(name);
    }
}
