package com.example.demo.dto;

import lombok.Data;

import java.awt.*;
import java.time.LocalDate;

@Data
public class ItemDto {

    private String name;

    private LocalDate date;

    private Point location;

    private String contacts;
}
