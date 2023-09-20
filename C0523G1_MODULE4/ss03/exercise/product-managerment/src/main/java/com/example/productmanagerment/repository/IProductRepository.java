package com.example.productmanagerment.repository;

import com.example.productmanagerment.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    void addProduct(Product product);
    void updateProduct(int id, Product product);
    void deleteProduct(int id);
    Product searchById(int id);
    Product searchByName(String name);

}
