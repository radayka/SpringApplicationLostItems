package com.example.demo.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserShortDto {

    private UUID userId;

    private String firstName;

    private String lastName;
}
