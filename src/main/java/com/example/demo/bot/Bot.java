package com.example.demo.bot;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Data
@Slf4j
public class Bot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;

    public Bot(String token) {
        this.telegramClient = new OkHttpTelegramClient(token);
    }

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
}

