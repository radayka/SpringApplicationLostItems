package com.example.demo;

import com.example.demo.bot.Bot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@EnableJpaRepositories
@SpringBootApplication
public class LostItemsApplication {

    public static void main(String[] args) throws TelegramApiException {
        try {
            String botToken = "7650653873:AAHhU4cEZG9Rqu6wYCZOT2tJ3YRhH-35gyk";
            TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication();
            botsApplication.registerBot(botToken, new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        SpringApplication.run(LostItemsApplication.class, args);

    }
}
