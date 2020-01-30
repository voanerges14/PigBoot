package com.little_pig_bot.controller;

import com.github.kshashov.telegram.api.TelegramMvcController;
import com.github.kshashov.telegram.api.bind.annotation.BotController;
import com.github.kshashov.telegram.api.bind.annotation.BotRequest;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@BotController
public class PigBotController implements TelegramMvcController {

    @BotRequest
    public BaseRequest onUpdate(Update update) {
        return new SendMessage(update.message().chat().id(), "I will... ");
    }
    @BotRequest(value = "/fucker")
    public BaseRequest ok(Update update) {
        return new SendMessage(update.message().chat().id(), "okay bro, okay!");
    }

    @Override
    public String getToken() {
        return "";
    }
}