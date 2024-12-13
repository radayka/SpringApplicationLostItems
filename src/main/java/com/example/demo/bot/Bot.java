package com.example.demo.bot;

import com.example.demo.consumer.Consumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;

@Slf4j
@Component
@RequiredArgsConstructor
public class Bot implements SpringLongPollingBot {
    private final Consumer consumer;

    @Value("${telegram.bot.token}")
    private String token;

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return consumer;
    }
}

