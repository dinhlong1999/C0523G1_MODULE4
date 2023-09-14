package com.example.exercise1.Service;

import org.springframework.stereotype.Service;

@Service

public class ExchangeService {

    public float exchangeMoney(float money){
        return money * 24000;
    }

}
