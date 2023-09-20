package com.example.productmanagerment.service;

import com.example.productmanagerment.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void addProduct(Product product);
    void updateProduct(int id,Product product);
    void deleteProduct(int id);
    Product searchById(int id);
    Product searchByName(String name);

}
