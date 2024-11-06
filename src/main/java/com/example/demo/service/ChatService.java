package com.example.demo.service;

import java.util.List;
import java.util.UUID;

public interface ChatService {

    void createChat(List<UUID> users);

}
