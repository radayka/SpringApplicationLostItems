package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.time.LocalDate;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private LocalDate date;

    @Column
    private Point location;

    @Column
    private String contacts;
}
