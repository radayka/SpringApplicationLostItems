package com.example.demo.bot.commands;

import com.example.demo.bot.service.Command;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Component
@Slf4j
public class AddUser extends AbstractCommand implements Command {
    private final UserRepository userRepository;

    public AddUser(TelegramClient telegramClient, UserRepository userRepository) {
        super(telegramClient);
        this.userRepository = userRepository;
    }

    @Override
    public void execute(Update update) {
        User user = new User();
        user.setFirstName(update.getMessage().getFrom().getFirstName());
        user.setLastName(update.getMessage().getFrom().getLastName());
        user.setUsername(update.getMessage().getFrom().getUserName());
        userRepository.save(user);
        execute(update, "Пользователь добавлен");

    }
}
