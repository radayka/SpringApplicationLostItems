package com.example.demo.dto;

import com.example.demo.entity.Chat;
import com.example.demo.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {

    @NotNull
    @NotBlank
    private String message;

    @NotNull
    private LocalDateTime sendTime;

    @NotNull
    private User author;

    @NotNull
    private Chat chat;

    @NotNull
    private boolean deleted;

}