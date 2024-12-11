package com.example.demo.bot;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Data
@Slf4j
@Component
public class Bot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;

    String botToken = "7650653873:AAHhU4cEZG9Rqu6wYCZOT2tJ3YRhH-35gyk";

    public Bot() {
        this.telegramClient = new OkHttpTelegramClient(botToken);
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            SendMessage message = SendMessage
                    .builder()
                    .chatId(chatId)
                    .text(text)
                    .build();
            try {
                telegramClient.execute(message);
            } catch (TelegramApiException telegramApiException) {
                log.error(telegramApiException.getMessage());
            }
        }
    }
}

