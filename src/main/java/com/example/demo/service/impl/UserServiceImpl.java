package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(UserDto user) {
        User newUser = new User();
        Base64.Encoder encoder = Base64.getEncoder();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(encoder.encodeToString(user.getPassword().getBytes()));

        userRepository.save(newUser);
    }

    @Override
    public User getUserById(UUID uuid) {
        return userRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateById(UserDto user, UUID uuid) {
        Base64.Encoder encoder = Base64.getEncoder();
        User updateUser = userRepository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(encoder.encodeToString(user.getPassword().getBytes()));

        userRepository.save(updateUser);
    }
}
