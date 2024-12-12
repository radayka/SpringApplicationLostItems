package com.example.demo.bot.commands;

import com.example.demo.bot.service.Command;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.telegram.telegrambots.meta.api.objects.Update;

public class AddUser implements Command {
    Update update;
    UserRepository userRepository;

    @Override
    public void execute() {
        User user = new User();
        user.setFirstName(update.getMessage().getFrom().getFirstName());
        user.setLastName(update.getMessage().getFrom().getLastName());
        user.setUsername(update.getMessage().getFrom().getUserName());
        userRepository.save(user);
    }
}
