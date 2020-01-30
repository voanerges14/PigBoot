package com.little_pig_bot.listener;


import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

//@Component
@Slf4j
public class PigBotService extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                .setChatId(update.getMessage().getChatId())
                .setText("FUCK YOU WITH YOUR MESSAGE \"" + update.getMessage().getText().toUpperCase() + "\"");

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                log.error("Send message error", e);
            }
        }
    }


    @Override
    public String getBotUsername() {
        return "";
    }

    @Override
    public String getBotToken() {
        return "";
    }

}
