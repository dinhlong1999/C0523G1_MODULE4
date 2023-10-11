package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    boolean save(Customer customer);
}
