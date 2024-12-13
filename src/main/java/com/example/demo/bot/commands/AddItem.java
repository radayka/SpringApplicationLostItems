package com.example.demo.bot.commands;

import com.example.demo.bot.service.Command;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
public class AddItem implements Command {
    private final ItemRepository itemRepository;
    Update update;
    TelegramClient telegramClient;

    @Override
    public void execute(Update update) {
        Item newItem = new Item();
        newItem.setName(update.getMessage().getFrom().getUserName());
        newItem.setDate(LocalDate.ofEpochDay(update.getMessage().getDate()));
        itemRepository.save(newItem);
        SendMessage sendMessage = SendMessage.builder()
                .chatId(update.getMessage().getChatId())
                .text("Предмет добавлен")
                .build();
        try {
            telegramClient.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }
}

