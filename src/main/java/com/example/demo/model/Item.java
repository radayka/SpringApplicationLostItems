package com.example.demo.model;

import lombok.Data;

import java.awt.*;
import java.time.LocalDate;

@Data
public class Item {
    private int id;
    private String name;
    private LocalDate date;
    private Point location;
    private String contacts;
}
