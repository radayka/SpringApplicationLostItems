package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Lob
    @NotNull
    private String message;

    @NotNull
    private LocalDateTime sendTime;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @NotNull
    private User author;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    @NotNull
    private Chat chat;

    @Column(nullable = false)
    private boolean deleted;
}

