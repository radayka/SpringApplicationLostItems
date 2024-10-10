package com.example.demo.controller;

import com.example.demo.entity.User;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }
    @PostMapping(value = "/user")
    public void create(@RequestBody User user) {
        service.create(user);
    }

}
