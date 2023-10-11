package com.example.seminar_test.service;

import com.example.seminar_test.model.TypeCar;
import com.example.seminar_test.repository.ITypeCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCarService  implements ITypeCarService{
    @Autowired
    private ITypeCarRepository typeCarRepository;
    @Override
    public List<TypeCar> showListType() {
        return typeCarRepository.findAll();
    }
}
