package com.example.demo.bot.commands;

import com.example.demo.bot.service.Command;
import com.example.demo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Component
@RequiredArgsConstructor
@Slf4j
public class DeleteItem implements Command {

    private final ItemRepository itemRepository;
    private final TelegramClient telegramClient;

    @Override
    public void execute(Update update) {
        itemRepository.deleteById(update.getMessage().getFrom().getId());
        SendMessage sendMessage = SendMessage
                .builder()
                .chatId(update.getMessage().getChatId())
                .text("Предмет удалён")
                .build();
        try {
            telegramClient.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }
}
