package com.example.productmanagerment.repository;

import com.example.productmanagerment.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    boolean addProduct(Product product);
    boolean updateProduct(int id, Product product);
    boolean deleteProduct(int id);
    Product searchById(int id);
    List<Product> searchByName(String name);

}
