package com.example.demo.bot.commands;

import com.example.demo.bot.service.Command;
import com.example.demo.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Component
@Slf4j
public class DeleteItem extends AbstractCommand implements Command {

    private final ItemRepository itemRepository;

    public DeleteItem(TelegramClient telegramClient, ItemRepository itemRepository, TelegramClient telegramClient1) {
        super(telegramClient);
        this.itemRepository = itemRepository;
    }

    @Override
    public void execute(Update update) {
        itemRepository.deleteById(update.getMessage().getFrom().getId());
        execute(update,"Предмет удалён");
    }
}
