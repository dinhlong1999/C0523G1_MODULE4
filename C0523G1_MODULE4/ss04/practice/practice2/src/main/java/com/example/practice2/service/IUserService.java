package com.example.practice2.service;

import com.example.practice2.model.Login;
import com.example.practice2.model.User;

public interface IUserService {
    User checkLogin(Login login);
}
