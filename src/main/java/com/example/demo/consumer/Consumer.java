package com.example.demo.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class Consumer implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            try {
                switch (message) {
                    case "/start" -> {
                        SendMessage sendMessage = SendMessage.builder()
                                .chatId(chatId)
                                .text("Привет!")
                                .build();
                        telegramClient.execute(sendMessage);
                    }
                    case "/addItem" -> {
                        SendMessage sendMessage = SendMessage.builder()
                                .chatId(chatId)
                                .text("Предмет добавлен")
                                .build();
                        telegramClient.execute(sendMessage);
                    }
                    case "/deleteItem" -> {
                        SendMessage sendMessage = SendMessage.builder()
                                .chatId(chatId)
                                .text("Предмет удалён")
                                .build();
                        telegramClient.execute(sendMessage);
                    }
                    default -> {
                        SendMessage sendMessage = SendMessage.builder()
                                .chatId(chatId)
                                .text("Команда не распознана")
                                .build();
                        telegramClient.execute(sendMessage);
                    }
                }
            } catch (TelegramApiException e) {
                log.error(e.getMessage());
            }
        }
    }
}

