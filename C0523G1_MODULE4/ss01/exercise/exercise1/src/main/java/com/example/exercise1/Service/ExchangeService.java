package com.example.exercise1.Service;

import org.springframework.stereotype.Service;

@Service

public class ExchangeService implements IExchangeService {

    public float exchangeMoney(float money){
        return money * 24000;
    }

}
