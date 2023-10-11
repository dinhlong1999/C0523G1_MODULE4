package com.example.practice2.Repository;

import com.example.practice2.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    void addCustomer(Customer customer);
}
