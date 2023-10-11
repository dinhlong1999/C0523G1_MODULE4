package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository{
    @Override
    public List<Customer> findAll() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Customer> query = session.createQuery("from Customer",Customer.class);
        return query.getResultList() ;
    }

    @Override
    public Customer findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Customer> query = session.createQuery("from Customer where id = :id",Customer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public boolean save(Customer customer) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(customer);
            transaction.commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
