package com.example.demo.service.impl;

import com.example.demo.entity.Chat;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.repository.ChatRepository;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    @Override
    public void writeMessage(UUID chatId, UUID userId, String message) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь не найден: " + userId));
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new IllegalArgumentException("Чат не найден: " + chatId));

        Message newMessage = new Message();
        newMessage.setId(UUID.randomUUID());
        newMessage.setMessage(message);
        newMessage.setAuthor(user);
        newMessage.setChat(chat);
        newMessage.setSendTime(LocalDateTime.now());
        messageRepository.save(newMessage);
    }
}
