package com.example.practice1.repository;

import com.example.practice1.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("from Customer",Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(int id) {
        TypedQuery<Customer> query = entityManager.createQuery("from Customer where id =:id",Customer.class);
        return query.getSingleResult();
    }
    @Transactional
    @Override
    public void save(Customer customer) {
        if (customer.getId() != null){
            entityManager.merge(customer);
        }else {
            entityManager.persist(customer);
        }
    }
    @Transactional
    @Override
    public void remove(int id) {
        Customer customer = findById(id);
        entityManager.remove(customer);
    }
}
