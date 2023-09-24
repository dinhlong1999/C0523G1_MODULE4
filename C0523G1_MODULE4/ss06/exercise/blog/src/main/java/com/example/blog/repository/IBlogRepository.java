package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findBlogByNameContaining(Pageable pageable, String name);

    @Query(value = "select * from blog where category_id = :id", nativeQuery = true)
    List<Blog> searchBlogByCategory_Id(@Param("id") int id);

}
