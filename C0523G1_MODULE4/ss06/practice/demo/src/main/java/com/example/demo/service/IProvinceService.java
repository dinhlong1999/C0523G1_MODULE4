package com.example.demo.service;

import com.example.demo.model.Province;

import java.util.Optional;

public interface IProvinceService {
    Iterable<Province> findAll();
    Optional<Province> findById(Long id);
    void remove(Long id);
    void save(Province province);

}
