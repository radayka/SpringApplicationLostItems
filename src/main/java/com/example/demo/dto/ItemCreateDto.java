package com.example.demo.dto;

import lombok.Data;

import java.awt.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ItemCreateDto {

    private String name;

    private LocalDate date;

    private Point location;

    private String contacts;

    private UUID userId;
}
