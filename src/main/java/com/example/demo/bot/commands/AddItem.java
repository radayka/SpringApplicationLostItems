package com.example.demo.bot.commands;

import com.example.demo.bot.service.Command;
import com.example.demo.entity.Item;
import com.example.demo.entity.User;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.time.LocalDate;

@Slf4j
@Component
public class AddItem extends AbstractCommand implements Command {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public AddItem(TelegramClient telegramClient, ItemRepository itemRepository, UserRepository userRepository) {
        super(telegramClient);
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void execute(Update update) {
        Item newItem = new Item();
        newItem.setName(update.getMessage().getFrom().getUserName());
        User newUser = userRepository.findById(newItem.getUser().getId()).orElse(null);
        newItem.setUser(newUser);
        newItem.setDate(LocalDate.ofEpochDay(update.getMessage().getDate()));
        itemRepository.save(newItem);
        execute(update, "Предмет добавлен!");
    }
}

