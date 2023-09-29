package com.example.exercise.repository;

import com.example.exercise.model.Blog;
import com.example.exercise.service.BlogService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> searchBlogByCategory_Id(Integer id);

}
