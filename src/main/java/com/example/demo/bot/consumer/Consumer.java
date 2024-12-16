package com.example.demo.bot.consumer;

import com.example.demo.bot.commands.DefaultCommand;
import com.example.demo.bot.service.Command;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class Consumer implements LongPollingSingleThreadUpdateConsumer {

    private final Map<String, Command> commandMap;
    private final DefaultCommand defaultCommand;

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            commandMap.getOrDefault(message, defaultCommand).execute(update);
        }
    }
}


