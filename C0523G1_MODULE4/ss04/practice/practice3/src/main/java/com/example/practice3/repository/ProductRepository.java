package com.example.practice3.repository;

import com.example.practice3.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        int index = products.indexOf(findById(id));
        products.set(index,product);
    }

    @Override
    public void remove(int id) {
        products.remove(findById(id));
    }
}
