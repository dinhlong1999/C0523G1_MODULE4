package com.example.seminar_test2.service;

import com.example.seminar_test2.model.Pig;

import java.util.List;

public interface IPigService {
    List<Pig> findAll();
    void delete(int id);

    Pig getPigById(int id);

    void save(Pig pig);
}
