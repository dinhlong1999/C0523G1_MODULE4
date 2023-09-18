package com.example.practice2.repository;

import com.example.practice2.model.Login;
import com.example.practice2.model.User;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Controller

public class UserRepository implements IUserRepository{
    private static final List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User("john","123456","John","john@codegym.vn"));
        users.add(new User("long","123456","Long","long@codegym.vn"));
        users.add(new User("van","123456","Van","van@gmail.com"));
    }
    @Override
    public User checkLogin(Login login) {
        for (User user: users) {
            if (user.getAccount().equals(login.getAccount()) && user.getPassword().equals(login.getPassword())){
                return user;

            }
        }
        return null;
    }
}
