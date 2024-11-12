package com.example.demo.controller;

import com.example.demo.service.MessageService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(value = "/chat/{id}/message/write")
    private void writeMessage(@RequestParam String message, @PathVariable UUID id, UUID chatId) {
        messageService.writeMessage(id, chatId, message);
    }
}
