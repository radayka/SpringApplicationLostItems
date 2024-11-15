package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String message;

    @Column
    private LocalDateTime sendTime;

    @JoinColumn(name = "author", nullable = false)
    @ManyToOne
    private User author;

    @JoinColumn(name = "chat", nullable = false)
    @ManyToOne
    private Chat chat;

    @Column
    private boolean deleted;

}
