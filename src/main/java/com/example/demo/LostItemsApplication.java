package com.example.demo;

import com.example.demo.bot.TelegramBotRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class LostItemsApplication {
    public static void main(String[] args) {
        TelegramBotRegister register = new TelegramBotRegister();
        register.startBot();
        SpringApplication.run(LostItemsApplication.class, args);
    }
}
