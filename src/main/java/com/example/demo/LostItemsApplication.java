package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class LostItemsApplication {
    public static void main(String[] args) {
        SpringApplication.run(LostItemsApplication.class, args);
    }
}
