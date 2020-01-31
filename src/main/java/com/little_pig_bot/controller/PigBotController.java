package com.little_pig_bot.controller;

import com.github.kshashov.telegram.api.TelegramMvcController;
import com.github.kshashov.telegram.api.bind.annotation.BotController;
import com.github.kshashov.telegram.api.bind.annotation.BotRequest;
import com.little_pig_bot.service.NoteService;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@BotController
@AllArgsConstructor
public class PigBotController implements TelegramMvcController {

    NoteService noteService;

    @BotRequest
    public void onUpdate(Update update) {
        noteService.saveNote(update);
    }

    @BotRequest(value = "/notes")
    public BaseRequest getNotes(Update update) {
        return new SendMessage(update.message().chat().id(), noteService.getNotes().toString());
    }

    @Override
    public String getToken() {
        return "";
    }
}