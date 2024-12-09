package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

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
    public UserDto getUserById(UUID uuid) {
        return convertToDto(userRepository.findById(uuid).orElse(null));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return convertToDto(userRepository.findAll());
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

    // TODO Сделать маппинг
    private UserDto convertToDto(User user) {
        return new UserDto();
    }

    private List<UserDto> convertToDto(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(convertToDto(user));
        }
        return userDtos;
    }
}
