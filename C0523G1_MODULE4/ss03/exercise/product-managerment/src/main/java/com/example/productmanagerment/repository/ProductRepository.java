package com.example.productmanagerment.repository;

import com.example.productmanagerment.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository implements IProductRepository{
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1,"IPhone 15 Pro Max",30000000,"Titan","Apple"));
        products.add(new Product(2,"AirPod pro",5000000,"White","Apple"));
        products.add(new Product(3,"Lenovo legion 5",35000000,"Gray","Lenovo"));
        products.add(new Product(4,"Asus TUF Dash 15",27000000,"Black ","Asus"));
    }
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        products.set(id,product);
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);

    }

    @Override
    public Product searchById(int id) {
        return products.get(id);
    }

    @Override
    public Product searchByName(String name) {
        return null;
    }

    @Override
    public int findId(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                return i;
            }
        }
        return 0;
    }

}
