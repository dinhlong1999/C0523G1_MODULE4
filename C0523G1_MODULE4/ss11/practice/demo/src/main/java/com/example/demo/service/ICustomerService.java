package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();
    Optional<Customer> findById(int id);
    Customer save (Customer customer);
    void remove(int id);
}
