package com.example.practice3.repository;

import com.example.practice3.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void remove(int id);
}