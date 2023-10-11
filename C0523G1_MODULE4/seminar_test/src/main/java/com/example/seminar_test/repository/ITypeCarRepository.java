package com.example.seminar_test.repository;

import com.example.seminar_test.model.TypeCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeCarRepository extends JpaRepository<TypeCar,Integer> {
}
