package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void create(User user);

    User findById(UUID uuid);

    List<User> getAllUsers();

    void updateById(User user, UUID uuid);

}
