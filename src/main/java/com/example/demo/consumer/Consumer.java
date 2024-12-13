package com.example.demo.consumer;

import com.example.demo.bot.commands.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
@RequiredArgsConstructor
public class Consumer implements LongPollingSingleThreadUpdateConsumer {

    private final Start start;
    private final AddItem addItem;
    private final AddUser addUser;
    private final DeleteItem deleteItem;
    private final DefaultCommand defaultCommand;

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            switch (message) {
                case "/start" -> start.execute(update);
                case "/addItem" -> addItem.execute(update);
                case "/addUser" -> addUser.execute(update);
                case "/deleteItem" -> deleteItem.execute(update);
                default -> defaultCommand.execute(update);
            }
        }
    }
}

