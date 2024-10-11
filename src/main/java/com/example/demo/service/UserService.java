package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void create(UserDto user);

    User getUserById(UUID uuid);

    List<User> getAllUsers();

    void updateById(UserDto user, UUID uuid);

}
