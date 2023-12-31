package com.example.productmanagerment.repository;

import com.example.productmanagerment.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
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
    public boolean addProduct(Product product) {
//        products.add(product);
        try {
            entityManager.persist(product);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean updateProduct(int id, Product product) {
//        products.set(id,product);
        Product productUpdate = searchById(id);
        if (productUpdate != null) {
            productUpdate.setName(product.getName());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setDescriber(product.getDescriber());
            productUpdate.setProducer(product.getProducer());
            entityManager.merge(productUpdate);
            return true;
        } else {
            return false;
        }

    }

    @Transactional
    @Override
    public boolean deleteProduct(int id) {
//        products.remove(id);
        Product product = searchById(id);
        if (product != null) {
            entityManager.remove(product);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Product searchById(int id) {
//        return products.get(id);
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> searchByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery("from Product where name like :name", Product.class);
        query.setParameter("name", name);
        return query.getResultList();
    }


}