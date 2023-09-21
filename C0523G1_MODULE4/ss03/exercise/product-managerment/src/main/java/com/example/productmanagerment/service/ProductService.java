package com.example.productmanagerment.service;

import com.example.productmanagerment.model.Product;
import com.example.productmanagerment.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public boolean addProduct(Product product) {
         return productRepository.addProduct(product);
    }

    @Override
    public boolean updateProduct(int id,Product product) {
        return productRepository.updateProduct( id, product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public Product searchById(int id) {
        return productRepository.searchById(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName("%"+name+"%");
    }


}
