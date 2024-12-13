package com.example.demo.bot.commands;

import com.example.demo.bot.service.Command;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Slf4j
@Component
public class DefaultCommand extends AbstractCommand implements Command {

    public DefaultCommand(TelegramClient telegramClient) {
        super(telegramClient);
    }

    public void execute(Update update) {
        execute(update, "Незвестная команда");
    }
}
