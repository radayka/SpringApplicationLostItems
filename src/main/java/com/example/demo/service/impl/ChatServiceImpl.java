package com.example.demo.service.impl;

import com.example.demo.entity.Chat;
import com.example.demo.entity.User;
import com.example.demo.repository.ChatRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    @Override
    public void createChat(List<UUID> userIds) {
        if (userIds == null || userIds.isEmpty()) {
            throw new IllegalArgumentException("Список пользователей не может быть пустым");
        }
        Chat chat = new Chat();
        chat.setId(UUID.randomUUID());
        List<User> users = userRepository.findAllById(userIds);
        chat.setUsers(users);
        chatRepository.save(chat);
    }
}
