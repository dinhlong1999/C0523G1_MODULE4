package com.example.seminar_test.service;

import com.example.seminar_test.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICarService {
    List<Car> findAll();

    void save(Car car);
    Page<Car> findCarByNameContaining(Pageable pageable, String name);

}
