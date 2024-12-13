package com.example.demo.bot.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command{
    void execute(Update update);
}
