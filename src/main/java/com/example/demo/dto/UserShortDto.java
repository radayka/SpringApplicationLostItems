package com.example.demo.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserShortDto {
    private UUID username;
    private String firstName;
    private String lastName;
}
