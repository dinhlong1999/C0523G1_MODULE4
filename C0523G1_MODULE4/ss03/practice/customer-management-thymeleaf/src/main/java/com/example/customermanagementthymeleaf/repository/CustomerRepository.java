package com.example.customermanagementthymeleaf.repository;

import com.example.customermanagementthymeleaf.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static final Map<Integer,Customer> customers ;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1,"Long","long1110dn@gmail.com","Tran Cao Van"));
        customers.put(2, new Customer(2,"Van","van123@gmail.com","Giap Van Cuong"));
        customers.put(3,new Customer(3,"Ronaldo","ronaldo@gmail.com","Portugal"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
