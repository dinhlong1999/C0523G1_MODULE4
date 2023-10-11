package com.example.seminar_test.service;

import com.example.seminar_test.model.Car;
import com.example.seminar_test.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService{

    @Autowired
    private ICarRepository carRepository;
    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public Page<Car> findCarByNameContaining(Pageable pageable, String name) {
        return carRepository.findCarByNameContaining(pageable,name);
    }
}
