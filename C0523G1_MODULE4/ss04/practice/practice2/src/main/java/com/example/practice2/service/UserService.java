package com.example.practice2.service;

import com.example.practice2.model.Login;
import com.example.practice2.model.User;
import com.example.practice2.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService  implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
