package com.example.demo.bot;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

@Slf4j
@Component
@RequiredArgsConstructor
public class TelegramBotRegistrar {
    private final Bot bot;

    @Value("${telegram.bot.token}")
    private String token;


    @PostConstruct
    public void registerBot() {
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(token, bot);
            log.info("Bot started");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
