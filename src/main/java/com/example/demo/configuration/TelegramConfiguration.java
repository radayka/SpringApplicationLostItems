package com.example.demo.configuration;

import com.example.demo.bot.commands.*;
import com.example.demo.bot.service.Command;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.Map;

@Configuration
public class TelegramConfiguration {
    @Value("${telegram.bot.token}")
    private String token;

    @Bean
    public TelegramClient telegramClient() {
        return new OkHttpTelegramClient(token);
    }

    @Bean
    public Map<String,Command> initCommandMap(Start start, AddItem addItem, AddUser addUser, DeleteItem deleteItem) {
        return Map.of(
                "/start", start,
                "/addItem", addItem,
                "/addUser", addUser,
                "/deleteItem", deleteItem
        );
    }
}
