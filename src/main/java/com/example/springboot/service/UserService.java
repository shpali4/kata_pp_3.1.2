package com.example.springboot.service;

import com.example.springboot.models.User;

import java.util.List;

public interface UserService {
    List<User> listOfUsers();
    User showUserById(long id);
    void updateUser(User user);
    void deleteUser(long id);
    void saveNewUser(User user);
}
