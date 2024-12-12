package com.example.demo.bot.commands;

import com.example.demo.bot.service.Command;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDate;

@AllArgsConstructor
public class AddItem implements Command {
    private final ItemRepository itemRepository;
    Update update;

    @Override
    public void execute() {
        Item newItem = new Item();
        newItem.setName(update.getMessage().getFrom().getUserName());
        newItem.setDate(LocalDate.ofEpochDay(update.getMessage().getDate()));
        itemRepository.save(newItem);
    }
}
