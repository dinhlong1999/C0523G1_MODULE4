package com.example.demo.service;

import com.example.demo.model.Bill;
import com.example.demo.repository.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BillService implements IBillService{
    @Autowired
    private IBillRepository billRepository;

    @Override
    public void save(Bill bill) {
        billRepository.save(bill);
    }
}
