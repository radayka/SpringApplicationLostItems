package com.example.demo.controller;

import com.example.demo.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ChatController {
    private final ChatService service;

    @Autowired
    public ChatController(ChatService chatService) {
        this.service = chatService;
    }

    @PostMapping(value = "/chat")
    @ResponseStatus(HttpStatus.CREATED)
    public void createChat(@RequestBody List<UUID> users) {
        service.createChat(users);
    }

}
