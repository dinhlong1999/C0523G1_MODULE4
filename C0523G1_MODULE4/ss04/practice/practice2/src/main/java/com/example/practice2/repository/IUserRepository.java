package com.example.practice2.repository;

import com.example.practice2.model.Login;
import com.example.practice2.model.User;

public interface IUserRepository {
     User checkLogin(Login login);
}
