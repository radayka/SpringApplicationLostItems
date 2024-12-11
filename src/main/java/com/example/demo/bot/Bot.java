package com.example.demo.bot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class Bot implements SpringLongPollingBot, LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;
    private final String token;

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            if (update.getMessage().getText().equals("/start")) {
                long chatId = update.getMessage().getChatId();
                SendMessage message = SendMessage
                        .builder()
                        .chatId(chatId)
                        .text("Привет!")
                        .build();
                try {
                    telegramClient.execute(message);
                } catch (TelegramApiException telegramApiException) {
                    log.error(telegramApiException.getMessage());
                }
            } else {
                long chatId = update.getMessage().getChatId();
                SendMessage message = SendMessage
                        .builder()
                        .chatId(chatId)
                        .text("Неизвестная команда")
                        .build();
                try {
                    telegramClient.execute(message);
                } catch (TelegramApiException telegramApiException) {
                    log.error(telegramApiException.getMessage());
                }
            }
        }
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return this;
    }
}

