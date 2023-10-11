package com.example.practice2.Service;

import com.example.practice2.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void addCustomer(Customer customer);
}
