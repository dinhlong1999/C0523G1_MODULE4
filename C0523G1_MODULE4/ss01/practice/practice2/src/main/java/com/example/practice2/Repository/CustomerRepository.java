package com.example.practice2.Repository;

import com.example.practice2.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository

public class CustomerRepository implements ICustomerRepository{
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1,"Ronaldo","ronaldo@gmail.com","Portugal"));
        customerList.add(new Customer(2,"Messi ","Messi@gmail.com","Argentina"));
        customerList.add(new Customer(3,"Hulk","Hulk@gmail.com","Brazil"));
        customerList.add(new Customer(4,"Ramos","Ramos@gmail.com","TBN"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }
}
