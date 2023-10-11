package com.example.seminar_test.repository;

import com.example.seminar_test.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICarRepository  extends JpaRepository<Car,Integer> {

    Page<Car> findCarByNameContaining(Pageable pageable, String name);
}
