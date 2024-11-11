package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }

    @PostMapping(value = "/user")
    public void create(@RequestBody UserDto user) {
        service.create(user);
    }

    @GetMapping(value = "/users")
    public List<UserDto> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping(value = "/user/{id}")
    public UserDto getUserById(@PathVariable UUID id) {
        return service.getUserById(id);
    }

    @PutMapping(value = "/user/{id}")
    public void updateById(@RequestBody UserDto user, @PathVariable UUID id) {
        service.updateById(user,id);
    }
}
