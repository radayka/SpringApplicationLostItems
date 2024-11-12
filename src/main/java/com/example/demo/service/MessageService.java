package com.example.demo.service;

import java.util.UUID;

public interface MessageService {
    void writeMessage(UUID userId,UUID chatId, String message);
}
