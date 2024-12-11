package com.example.demo;

import com.example.demo.bot.TelegramBotRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class LostItemsApplication {

    @Autowired
    private TelegramBotRegister telegramBotRegister;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LostItemsApplication.class, args);
        LostItemsApplication application = context.getBean(LostItemsApplication.class);
        application.telegramBotRegister.startBot();
    }
}
