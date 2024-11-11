package com.example.demo.service;

import com.example.demo.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void create(UserDto user);

    UserDto getUserById(UUID uuid);

    List<UserDto> getAllUsers();

    void updateById(UserDto user, UUID uuid);

}
