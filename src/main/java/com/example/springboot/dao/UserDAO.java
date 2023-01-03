package com.example.springboot.dao;

import com.example.springboot.models.User;

import java.util.List;

public interface UserDAO {
    List<User> listOfUsers();
    User showUserById(long id);
    void updateUser(User user);
    void deleteUser(long id);
    void saveNewUser(User user);
}