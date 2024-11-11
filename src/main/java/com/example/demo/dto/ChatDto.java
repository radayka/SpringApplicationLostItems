package com.example.demo.dto;

import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class ChatDto {

    private List<User> users;

    private List<Message> messages;

}