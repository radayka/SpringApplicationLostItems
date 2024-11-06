package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Chat {
    @Id
    private UUID id;
    @Column
    private List<User> users;
    @Column
    private List<Message> messages;

}
