package com.example.exercise2.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    private static  Map<String, String> list = new HashMap<>();
    static {
        list.put("Football","Bóng đá");
        list.put("Book","Sách");
        list.put("Dog","Chó");
        list.put("Cat","Mèo");
        list.put("Car","Ô tô");
    }
    public String dictionary(String text){
      return list.get(text);
    }
}
