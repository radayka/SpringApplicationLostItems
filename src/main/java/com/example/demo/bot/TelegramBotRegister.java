package com.example.demo.bot;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

@Component
@Slf4j
public class TelegramBotRegister {

    @Value("${telegram.bot.token}")
    String token;

    public void startBot() {
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(token, new Bot());
            log.info("Bot started");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
