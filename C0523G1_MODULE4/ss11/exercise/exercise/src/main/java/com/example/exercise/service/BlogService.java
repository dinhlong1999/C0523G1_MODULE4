package com.example.exercise.service;

import com.example.exercise.model.Blog;
import com.example.exercise.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public List<Blog> findBlogByCategoryId(Integer id) {
        return blogRepository.searchBlogByCategory_Id(id);
    }
}
