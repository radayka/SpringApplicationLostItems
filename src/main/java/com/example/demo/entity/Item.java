package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    @NotNull
    private String name;

    @Column(nullable = false)
    @NotNull
    private LocalDate date;

    @Column
    private Point location;

    @Lob
    @Column
    private String contacts;
}
