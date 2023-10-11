package com.example.practice1.repository;

import com.example.practice1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository  extends JpaRepository<User, Integer> {
}
