package com.example.demo.bot.commands;

import com.example.demo.bot.service.Command;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Component
@Slf4j
public class Start extends AbstractCommand implements Command {


    public Start(TelegramClient telegramClient) {
        super(telegramClient);
    }

    @Override
    public void execute(Update update) {
        execute(update, "Привет!");
    }
}
