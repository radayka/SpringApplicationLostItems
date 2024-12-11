package com.example.demo;

import com.example.demo.bot.Bot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@EnableJpaRepositories
@SpringBootApplication
public class LostItemsApplication {
    public static void main(String[] args) throws TelegramApiException {

        String botToken = "7650653873:AAHhU4cEZG9Rqu6wYCZOT2tJ3YRhH-35gyk";

        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(botToken, new Bot());
            log.info("Bot started");
            Thread.currentThread().join();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        SpringApplication.run(LostItemsApplication.class, args);

    }
}
