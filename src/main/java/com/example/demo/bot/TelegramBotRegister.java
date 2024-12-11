package com.example.demo.bot;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

@Component
@Slf4j
public class TelegramBotRegister {


    String token = "7650653873:AAHhU4cEZG9Rqu6wYCZOT2tJ3YRhH-35gyk";

    @PostConstruct
    public void startBot() {
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(token, new Bot());
            log.info("Bot started");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
