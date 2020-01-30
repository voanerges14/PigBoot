package com.little_pig_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class LittlePigBotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(LittlePigBotApplication.class, args);
	}
}
