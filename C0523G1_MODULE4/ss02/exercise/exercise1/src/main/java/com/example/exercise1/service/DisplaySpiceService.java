package com.example.exercise1.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisplaySpiceService implements IDisplaySpiceService{
    private static final List<String> spiceList = new ArrayList<>();


    @Override
    public List<String> showList() {
        return spiceList;
    }

    @Override
    public void addSpice(String[] spice) {
        for (String string:spice) {
            spiceList.add(string);
        }
    }
}
