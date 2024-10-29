package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Item item;

    @Column(nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @Column(nullable = false)
    private String username;

    @Column
    private String password;
}
