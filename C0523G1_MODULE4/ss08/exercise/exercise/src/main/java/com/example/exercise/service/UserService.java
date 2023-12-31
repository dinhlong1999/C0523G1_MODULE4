package com.example.exercise.service;

import com.example.exercise.model.User;
import com.example.exercise.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
