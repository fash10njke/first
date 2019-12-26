package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {

    User getUser(String login);
    String encoderPassword(String password);
    void add(User user);
    List<User> listUsers();
}