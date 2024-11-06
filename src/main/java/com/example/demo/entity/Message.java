package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Message {

    @Id
    @NotNull
    private UUID id;

    @NotNull
    @NotBlank
    private String message;

    @NotNull
    private LocalDateTime sendTime;

    @NotNull
    private User author;

    private Chat chat;

    @NotNull
    private boolean deleted;

}
