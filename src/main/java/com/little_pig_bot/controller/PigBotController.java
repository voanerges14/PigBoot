package com.little_pig_bot.controller;

import com.github.kshashov.telegram.api.MessageType;
import com.github.kshashov.telegram.api.TelegramMvcController;
import com.github.kshashov.telegram.api.bind.annotation.BotController;
import com.github.kshashov.telegram.api.bind.annotation.BotPathVariable;
import com.github.kshashov.telegram.api.bind.annotation.BotRequest;
import com.github.kshashov.telegram.api.bind.annotation.request.CallbackQueryRequest;
import com.github.kshashov.telegram.api.bind.annotation.request.MessageRequest;
import com.little_pig_bot.model.Note;
import com.little_pig_bot.service.NoteService;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@BotController
@AllArgsConstructor
public class PigBotController implements TelegramMvcController {

    private final NoteService noteService;

    @MessageRequest
    public void addMessage(Update update) {
        noteService.saveNote(update);
    }

    @BotRequest(path = "/notes")
    public BaseRequest getNotes(Chat chat) {
        return new SendMessage(chat.id(), noteService.getNotes(chat.id().intValue()).toString());
    }

    @BotRequest(path = "/start")
    public BaseRequest doStart(Chat chat) {
        return new SendMessage(chat.id(), "/notes to see the notes ")
            .replyMarkup(new ReplyKeyboardMarkup(new String[]{"/start", "/notes", "/web"}));
    }

    @BotRequest(path = "/delete {id}")
    public BaseRequest deleteNote(Chat chat,  @BotPathVariable("id") Long id){
        noteService.deleteNote(id);
        return new SendMessage(chat.id(), "Done");
    }

    @CallbackQueryRequest(path = "/web")
    public BaseRequest getWebView(Chat chat) {
        return new SendMessage(chat.id(), "<a href='http://localhost:3000/notes'>link </a>")
            .parseMode(ParseMode.HTML);
    }

    @Override
    public String getToken() {
        return "591199063:AAHN3K8g2CNa0jBXt_HV10PuV5Gbh6Rv058";
    }
}