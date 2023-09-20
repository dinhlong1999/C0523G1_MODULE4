package com.example.productmanagerment.repository;

import com.example.productmanagerment.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;
//    private static List<Product> products = new ArrayList<>();

    //    static {
//        products.add(new Product(1,"IPhone 15 Pro Max",30000000,"Titan","Apple"));
//        products.add(new Product(2,"AirPod pro",5000000,"White","Apple"));
//        products.add(new Product(3,"Lenovo legion 5",35000000,"Gray","Lenovo"));
//        products.add(new Product(4,"Asus TUF Dash 15",27000000,"Black ","Asus"));
//    }
    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void addProduct(Product product) {
//        products.add(product);
            entityManager.persist(product);
    }
    @Transactional
    @Override
    public void updateProduct(int id, Product product) {
//        products.set(id,product);
        Product productUpdate = searchById(id);
        productUpdate.setName(product.getName());
        productUpdate.setPrice(product.getPrice());
        productUpdate.setDescriber(product.getDescriber());
        productUpdate.setProducer(product.getProducer());
        entityManager.merge(productUpdate);

    }
    @Transactional
    @Override
    public void deleteProduct(int id) {
//        products.remove(id);
        Product product = searchById(id);
        entityManager.remove(product);

    }

    @Override
    public Product searchById(int id) {
//        return products.get(id);
        return entityManager.find(Product.class,id);
    }

    @Override
    public Product searchByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery("from Product where name = :name",Product.class);
        query.setParameter("name",name);
        return query.getSingleResult();
    }


}