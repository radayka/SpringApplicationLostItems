package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "t_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String name;

    @Column
    private LocalDate date;

    @Column
    private Point location;

    @Column
    private String contacts;
}
