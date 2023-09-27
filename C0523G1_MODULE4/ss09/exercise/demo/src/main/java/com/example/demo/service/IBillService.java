package com.example.demo.service;

import com.example.demo.model.Bill;

public interface IBillService {
    void save(Bill bill);
    Bill getBillByCode(int code);

}
